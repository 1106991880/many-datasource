package com.yang.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yang
 * @Date: 2020/10/16 10:06
 * @Description:
 */
public class TestJava8 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(12, "yangzhibin"));
        students.add(new Student(13, "huluming"));
        students.add(new Student(14, "liuzhidong"));
        students.stream().filter((e) -> e.getAge() >= 12).forEach(System.out::println);
    }



    @Test
    public void  test(){

        System.out.println("da");


    }
}