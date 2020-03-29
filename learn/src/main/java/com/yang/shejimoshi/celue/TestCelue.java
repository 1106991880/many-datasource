package com.yang.shejimoshi.celue;

/**
 * @Author: yang
 * @Date: 2020-03-23 21:19
 * @Description: 测试策略模式
 */
public class TestCelue {
    public void getPrice(String level) {
        Long price = null;
        if (level.equals("普通会员")) {
            price = (long) (100 * 100);
        }
        if (level.equals("黄金会员")) {
            price = (long) (100 * 150);
        }
        if (level.equals("铂金会员")) {
            price = (long) (100 * 200);
        }
    }
}
