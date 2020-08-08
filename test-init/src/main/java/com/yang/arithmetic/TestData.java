package com.yang.arithmetic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yang
 * @Date: 2020-07-04 01:07
 * @Description: 学习算法 编写算法题目
 *
 * 50瓶饮料，喝完三个空瓶可以换一瓶饮料，请问总共可以喝多少瓶饮料
 *
 */
public class TestData {

    public static void main(String[] args) {


        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        System.out.println("size:" + set.size());


        set.forEach((v)->{
            System.out.println("vvvvvvvvvvv-"+v);
        });


        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }


    }

}
