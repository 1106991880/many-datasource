package com.yang.fankonghui;

public class Test10 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 10; i++) {
            a = a++;
            b = ++b;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
