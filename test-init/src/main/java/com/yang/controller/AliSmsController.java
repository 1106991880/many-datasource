package com.yang.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.yang.utils.jsonString.JsonStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yang
 * @Date: 2020-08-02 22:32
 * @Description: 阿里云短信服务
 */
@Controller
@RequestMapping("/sms")
public class AliSmsController {

    private static final Logger log = LoggerFactory.getLogger(AliSmsController.class);

    // 传递手机号码，发送短信到手机号码
    // 做登录验证码还需要集成redis 做验证码过期操作
    @ResponseBody
    @RequestMapping(value = "/sendSms", method = RequestMethod.POST)
    public String sendSms(@RequestBody String json) {
        log.info("短信验证码===" + json);
        // ID和key都是从阿里云上面申请的
        // 地址 https://dysms.console.aliyun.com/dysms.htm?spm=a2c8b.12215442.nav-right.2.59e3336aj9yjA4#/domestic/text/sign
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G8x2n7L2Rkf9weTqrWu", "OUPD3eiDb5Ra378G1A5IRLQ65zwErg");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");// 不用变
        request.setSysVersion("2017-05-25");// 不用变
        request.setSysAction("SendSms");// 不用变
        // 自定义参数 必须按照文档来写 阿里云官网不能乱写个人的签名管理，否则申请不通过
        request.putQueryParameter("PhoneNumbers", "13121638540");// 发送到的短信号码
        request.putQueryParameter("SignName", "ABC商城");//这个汉字是阿里云的签名管理的签名名称
        request.putQueryParameter("TemplateCode", "SMS_198692664");//模板管理下面的模板code
        // 构建短信验证码
        Map<String, Object> map = new HashMap<>();
        // 生成随机验证码
        int randomCode = (int) ((Math.random() * 9 + 1) * 100000);
        System.out.println("短信验证码===" + randomCode);
        map.put("code", randomCode);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            // 是否响应成功
            System.out.println("响应是否成功" + response.getData());
            return JsonStringUtils.JsonData(true, "发送短信成功", response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return JsonStringUtils.JsonData(false, "发送短信失败", null);
    }

}
