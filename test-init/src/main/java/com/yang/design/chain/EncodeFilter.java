package com.yang.design.chain;

public class EncodeFilter extends Filter {

    @Override
    public void doFilter(String request, String response, FilterChain filterChain) {
        System.out.println("对request做utf-8编码");
        filterChain.doFilter(request, response);
        System.out.println("对response做utf-8编码");
    }

}