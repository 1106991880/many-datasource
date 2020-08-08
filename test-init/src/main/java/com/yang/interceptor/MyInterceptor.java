package com.yang.interceptor;

import com.yang.utils.jsonString.JsonStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yang
 * @Date: 2020-07-26 21:41
 * @Description: 拦截器
 */
@Component
public class MyInterceptor implements HandlerInterceptor {


    // 调用时间：Controller方法处理之前
    // 执行顺序：链式Interceptor情况下，Interceptor按照声明的顺序一个接一个执行
    // 若返回false，则中断执行，注意：不会进入afterCompletion
    // 一般可以用来拦截token信息
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String queryString = request.getQueryString();
        String requestURL = request.getRequestURL().toString();
        System.out.println("拦截器1，如入参：" + queryString + "访问地址，" + requestURL);

        // 被拦截的请求返回的json格式的提示
        // 返回false的请求才进行响应 比如提示:被拦截器拦截下来了/登录信息过去
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=UTF-8");
//        PrintWriter writer = response.getWriter();
//        String interceptorData = JsonStringUtils.JsonData(false, "被拦截器拦截", null);
//        writer.write(interceptorData);

        return true;
    }

    // 调用前提：preHandle返回true
    // 调用时间：Controller方法处理完之后，DispatcherServlet进行视图的渲染之前，
    // 也就是说在这个方法中你可以对ModelAndView进行操作
    // postHandle虽然post打头，但post、get方法都能处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("拦截器2");
    }

    // 调用前提：preHandle返回true
    // 调用时间：DispatcherServlet进行视图的渲染之后
    // 多用于清理资源
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("拦截器3");
    }


}
