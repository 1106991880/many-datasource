package com.yang.suanfa;

/**
 * @Author: yang
 * @Date: 2020-08-26 21:39
 * @Description: 设计模式-单例设计模式之饿汉式
 */
public class Hungry {
    private Hungry() {
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return new Hungry();
    }

    public static void main(String[] args) {

        System.out.println();

    }


}
