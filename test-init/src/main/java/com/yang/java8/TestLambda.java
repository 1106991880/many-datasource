package com.yang.java8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Author: yang
 * @Date: 2020/10/16 10:15
 * @Description: lambda表达式操作符->
 */
public class TestLambda {
    public static void main(String[] args) {
        Consumer<Student> com = (x) -> System.out.println(x.getAge());
        com.accept(new Student(12, "123"));
        Comparator<Integer> comparator = (x, y) -> x * y;
        System.out.println(comparator.compare(5, 2));
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(5, 3));
    }
}