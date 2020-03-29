package com.yang.shejimoshi;

/**
 * @Author: yang
 * @Date: 2020-03-16 21:56
 * @Description: 饿汉 单例设计模式
 */
public class Testlanhan {
    private static Testlanhan user01 ;

    //构造私有化之后 就不能创建对象了
    private Testlanhan() {

    }

    private static synchronized Testlanhan getInstance() {
        if (user01==null){
            user01=new Testlanhan();
        }
        return user01;
    }

    public static void main(String[] args) {
        Testlanhan instance = Testlanhan.getInstance();
        Testlanhan instance1 = Testlanhan.getInstance();
        System.out.println(instance == instance1);//true 说明是同一个对象

    }
}
