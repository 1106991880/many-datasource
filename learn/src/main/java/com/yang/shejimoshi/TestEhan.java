package com.yang.shejimoshi;

/**
 * @Author: yang
 * @Date: 2020-03-16 21:56
 * @Description: 饿汉 单例设计模式
 */
public class TestEhan {
    private static final TestEhan user01 = new TestEhan();

    //构造私有化之后 就不能创建对象了
    private TestEhan() {

    }

    private static TestEhan getInstance() {
        return user01;
    }

    public static void main(String[] args) {
        TestEhan instance = TestEhan.getInstance();
        TestEhan instance1 = TestEhan.getInstance();
        System.out.println(instance == instance1);//true 说明是同一个对象

    }
}
