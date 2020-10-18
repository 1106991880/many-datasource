package com.yang.design.chain;


import java.util.ArrayList;
import java.util.List;

/**
 * 定义内部处理的filter链，链中保存真正filter的执行顺序，和servlet
 */
public class FilterChain {
    private int cursor = 0;
    public List<Filter> filters = new ArrayList<Filter>();
    public Servlet servlet;

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public void doFilter(String request, String response) {
        if (cursor < filters.size()) {
            filters.get(cursor++).doFilter(request, response, this);
        } else {
            servlet.service(request, response);
        }
    }
}