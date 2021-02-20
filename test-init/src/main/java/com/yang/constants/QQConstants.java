package com.yang.constants;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * qq 登陆常量配置类
 */
@Configuration
@Data
public class QQConstants {

    // 你的appId
    @Value("${oauth.qq.client_id}")
    private String client_id;

    // 你的appKey
    @Value("${oauth.qq.client_secret}")
    private String client_secret;

    // 你接收响应code码地址
    @Value("${oauth.qq.redirect_uri}")
    private String redirect_uri;

    // 腾讯获取code码地址
    @Value("${oauth.qq.code_callback_uri}")
    private String code_callback_uri;

    // 腾讯获取access_token地址
    @Value("${oauth.qq.access_token_callback_uri}")
    private String access_token_callback_uri;

    // 腾讯获取openid地址
    @Value("${oauth.qq.openid_callback_uri}")
    private String openid_callback_uri;

    // 腾讯获取用户信息地址
    @Value("${oauth.qq.user_info_callback_uri}")
    private String user_info_callback_uri;

}
