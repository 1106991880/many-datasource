package com.yang.fankonghui;

public class Test07 {
    public static void main(String[] args) {
        String x="123";
        String y = new String("123");
        String z=y;
        System.out.println(x==y);
        System.out.println(y==z);
    }
}
