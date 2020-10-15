package com.yang.fankonghui;

public class Test09 {
    private String name;

    public static void main(String[] args) {
        Test09 test09 = new Test09();
        new Thread() {
            public void run() {
                test09.name = "jack";
            }
        }.start();

        test09.name = "tom";
        new Thread() {
            public void run() {
                if (test09.name.equals("tom")) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }.start();
    }
}
