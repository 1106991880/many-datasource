package com.yang.java8;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author: yang
 * @Date: 2020/10/16 10:55
 * @Description: java8内置的函数式接口 4个接口
 */
public class FunctionInterface {

    public static void main(String[] args) {
        // 消费型接口
        //Consumer
        // 供给型接口
        // 函数式接口
        // 断言型接口
        Function<Integer, Integer> a = (x) -> x * 10;
        System.out.println(a.apply(10));


    }

}