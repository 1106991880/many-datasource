package com.yang.filter;

import com.yang.utils.jsonString.JsonStringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @Author: yang
 * @Date: 2020-07-26 22:21
 * @Description: 过滤器 过滤器比拦截器先执行
 */
@Order(1)// 多个过滤器的时候这个过滤器最先执行
@Component
//@WebFilter：表示这个class是过滤器。
//里面的参数，filterName 为过滤器名字，urlPatterns 为过滤器的范围，initParams 为过滤器初始化参数。
//过滤器里面的三个方法
//init:filter对象只会创建一次，init方法也只会执行一次
//doFilter:主要的业务代码编写方法，可以多次重复调用
//destroy:在销毁Filter时自动调用（程序关闭或者主动销毁Filter）
@WebFilter(filterName = "myFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "URL", value = "http://localhost:9090")})
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化方法");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器执行业务的方法");

        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        System.out.println("过滤器请求参数===" + parameterMap);

        // 放行至下一个过滤器或者放行
        filterChain.doFilter(servletRequest, servletResponse);
//        servletResponse.setCharacterEncoding("UTF-8");
//        servletResponse.setContentType("application/json;charset=UTF-8");
//        PrintWriter writer = servletResponse.getWriter();
//        String interceptorData = JsonStringUtils.JsonData(false, "被过滤器阻止了", null);
//        writer.write(interceptorData);


    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁的方法，在销毁时自动调用");
    }

}
