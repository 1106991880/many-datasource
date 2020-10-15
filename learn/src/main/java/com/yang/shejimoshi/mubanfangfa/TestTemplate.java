package com.yang.shejimoshi.mubanfangfa;

/**
 * @Author: yang
 * @Date: 2020-03-18 22:45
 * @Description: 模板方法设计模式
 */
public class TestTemplate {
    public static void main(String[] args) {
        System.out.println("测试代码");
        MsgTemplate yiDong = new YiDong();
        yiDong.sendMsg();
    }
}
