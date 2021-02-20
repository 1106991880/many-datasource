package com.yang.suanfa;

import com.yang.java8.Student;
import lombok.val;

import java.util.Optional;

/**
 * @Author: yang
 * @Date: 2020-10-18 22:52
 * @Description:
 */
public class TestOptional {

    public static void main(String[] args) {

        Optional<Student> empty = Optional.empty();
        //System.out.println(empty.get());
        if (empty.isPresent()) {
            System.out.println("有值");
        }

        Student student = empty.orElse(new Student(2, "1"));

        System.out.println(student);


        Student student1 = empty.orElseGet(() -> new Student());

        Optional<Student> o = Optional.ofNullable(null);
        System.out.println(o);
//        System.out.println(o.get());


    }
}
