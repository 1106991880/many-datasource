package com.yang.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.yang.config.AlipayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yang
 * @Date: 2020/12/14 下午3:11
 * @Description: 集成支付宝支付
 */
@RestController
@RequestMapping("/alipay")
@Slf4j
public class AlipayController {

    @RequestMapping(value = "/goAlipay", produces = "text/html; charset=UTF-8")
    public String goAlipay(@RequestBody Map map) throws Exception {
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        // 设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        String test = "111";
        // 设置订单号
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String format = sDateFormat.format(new Date());
        // 商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = map.get("orderId").toString().trim();
        // 付款金额，必填
        String total_amount = map.get("price").toString().trim();
        // 订单名称，必填
        String subject = "测试";
        // 商品描述，可空
        String body = "用户订购商品个数：" + 1;

        // 这里向数据库中添加数据,购买的这条商品信息
        // 名称,数量,单价,付款金额,订单号(唯一),支付状态(未支付)
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        // 请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;
    }


    // 支付宝回调接口
    @PostMapping("/notify")
    private String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status)
            throws AlipayApiException {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            map.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (com.alipay.api.AlipayApiException e) {
            log.info("notify 验证失败", e);
            // 验签发生异常,则直接返回失败
            return ("--failed--");
        }
        if (signVerified) {
            //处理你的业务逻辑，更细订单状态等
            return ("--success--");
        } else {
            log.info("验证失败,不去更新状态");
            return ("--failed--");
        }
    }


    // 支付宝回调
    @GetMapping("/return")
    private String alipayReturn(Map<String, String> params, HttpServletRequest request, String out_trade_no, String trade_no, String total_amount)
            throws AlipayApiException {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                System.out.println(valueStr);
            }
            map.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(map, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            log.info("支付宝回调异常", e);
            // 验签发生异常,则直接返回失败
            return ("--fail--");
        }
        if (signVerified) {
            return ("--success--");
        } else {
            return ("fail");
        }
    }

    // 退款
    @RequestMapping("/refund")
    public void toRefund(HttpServletResponse response) throws IOException, AlipayApiException {
        // 设置编码格式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key,
                AlipayConfig.format, AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        // 设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        // 商户订单号，必填
        String out_trade_no = new String("20200524");
        // 需要退款的金额，该'金额不能大于订单金额，必填
        String refund_amount = new String("198");
        // 标识一次退款请求，同一笔交易多次退款需要保证唯一。如需部分退款，则此参数必传；不传该参数则代表全额退款
        String out_request_no = new String(UUID.randomUUID().toString());
        // 字符转义很重要
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"refund_amount\":\"" + refund_amount + "\","
                + "\"out_request_no\":\"" + out_request_no + "\"}");
        // 请求
        String result = alipayClient.execute(alipayRequest).getBody();
        out.println(result);
        // 以下写自己的订单退款代码
        log.info("返回结果={}", result);

        // 复杂的存储过程
    }
}