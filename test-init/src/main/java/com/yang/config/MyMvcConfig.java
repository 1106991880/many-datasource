package com.yang.config;

import com.yang.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: yang
 * @Date: 2020-07-26 21:47
 * @Description: 注册拦截器 对部分请求进行拦截 对部分请求进行放行
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // .addPathPatterns("/**") // 拦截所有请求
        // .excludePathPatterns("/login", "/register"); //排除登录注册
        // addPathPatterns 用来设置拦截路径，excludePathPatterns 用来设置白名单，也就是不需要触发这个拦截器的路径。
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/register");

    }
}
