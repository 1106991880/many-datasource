package com.yang.controller;

import com.yang.constants.QQConstants;
import com.yang.utils.http.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: yang
 * @Date: 2020/10/13 16:08
 * @Description: QQ登录接口 http调用的时候也可以使用restTemplate类
 */
@RestController
@RequestMapping("/qq")
@Slf4j
public class QqLoginController {

    @Autowired
    private QQConstants qqConstants;

    @Autowired
    private RestTemplate restTemplate;

    // 点击QQ登录走这个接口 会弹出网页版QQ授权登录的页面
    @GetMapping("/login/qq")
    public void loginQQ(HttpServletResponse response) {
        // 发送请求
        String forObject = restTemplate.getForObject("", String.class);
        try {
            response.sendRedirect(qqConstants.getCode_callback_uri() + // 获取code码地址
                    "?client_id=" + qqConstants.getClient_id() + // appId
                    "&state=" + UUID.randomUUID() + // 这个说是防攻击的，就给个随机uuid吧
                    "&redirect_uri=" + qqConstants.getRedirect_uri() +//这个很重要，这个是回调地址，即就收腾讯返回的code码
                    "&response_type=code");// 授权模式，授权码模式
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 接收code码值
    // 接收回调地址带过来的code码
    @GetMapping("/authorize/qq")
    public String authorizeQQ(String code) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        params.put("redirect_uri", qqConstants.getRedirect_uri());
        params.put("client_id", qqConstants.getClient_id());
        params.put("client_secret", qqConstants.getClient_secret());
        // 获取access_token如：access_token=9724892714FDF1E3ED5A4C6D074AF9CB&expires_in=7776000&refresh_token=9E0DE422742ACCAB629A54B3BFEC61FF
        String result = HttpUtils.getRequest(qqConstants.getAccess_token_callback_uri(), params);
        // 对拿到的数据进行切割字符串
        String[] strings = result.split("&");
        // 切割好后放进map
        Map<String, String> results = new HashMap<>();
        for (String str : strings) {
            String[] split = str.split("=");
            if (split.length > 1) {
                results.put(split[0], split[1]);
            }
        }
        // 到这里access_token已经处理好了
        // 下一步获取openid，只有拿到openid才能拿到用户信息
        String openidContent = HttpUtils.getRequest(qqConstants.getOpenid_callback_uri() + "?access_token=" + results.get("access_token"));
        log.info("获取openId的返回结果==========================" + openidContent);
        // 接下来对openid进行处理
        // 截取需要的那部分json字符串
        String openId = openidContent.substring(openidContent.indexOf("{"), openidContent.indexOf("}") + 1);
        log.info("截取完成的openId=======================" + openId);
        // 登录的业务逻辑 如果用户从来没有登录过 需要绑定一个账号
        // 用户已经绑定过账号直接登录即可
        // 接下来说说获取用户信息部分
        // 登陆的时候去数据库查询用户数据对于openid是存在，如果存在的话，就不用拿openid获取用户信息了，而是直接从数据库拿用户数据直接认证用户，
        // 否则就拿openid去腾讯服务器获取用户信息，并存入数据库，再去认证用户
        // 下面关于怎么获取用户信息，并登陆
        // 通过openId获取用户基本信息
        params.clear();
        params.put("access_token", results.get("access_token"));// 设置access_token
        params.put("openid", openId);// 设置openId
        params.put("oauth_consumer_key", qqConstants.getClient_id());//设置appId
        //获取用户信息
        String userInfo = HttpUtils.getRequest(qqConstants.getUser_info_callback_uri(), params);
        // 这里拿用户昵称，作为用户名，openid作为密码（正常情况下，在开发时候用openid作为用户名，再自己定义个密码就可以了）
        try {


        } catch (Exception e) {
            // 登录失败的页面
            return "login.html";
        }
        // 登录成功的页面
        return "redirect:/index";
    }

}