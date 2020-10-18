package com.yang.stream;

import com.yang.java8.Student;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author: yang
 * @Date: 2020/10/16 14:53
 * @Description:
 */
public class TestStream {
    public static void main(String[] args) {
        System.out.println("测试流stream");
        Student students[] = new Student[10];
        Stream<Student> stream = Arrays.stream(students);
        stream.forEach((x) -> System.out.println("-----------------+" + x));
    }
}