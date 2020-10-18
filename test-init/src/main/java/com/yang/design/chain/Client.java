package com.yang.design.chain;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 定义filter
        Filter encodeFilter = new EncodeFilter();
        Filter xssFilter = new XssFilter();
        FilterChain chain = new FilterChain();
        chain.addFilter(encodeFilter);
        chain.addFilter(xssFilter);
        // 定义servlet
        Servlet servlet = new MainServlet();
        chain.setServlet(servlet);
        chain.doFilter("发送请求", "");
    }

    public List<T> getData() {
        List<T> objects = new ArrayList<>();
        return objects;
    }
}