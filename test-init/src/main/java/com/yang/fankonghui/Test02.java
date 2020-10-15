package com.yang.fankonghui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test02 {
    public static void main(String[] args) {
        Integer[] data = {2, 4, 1, 3, 5};
        List<Integer> collect = Arrays.stream(data).collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            int integer = collect.get(i);
            if (integer % 2 == 0) {
                collect.remove(i);
            }
        }
        System.out.println(collect);
    }
}
