package com.yang.fankonghui;

public class Test08 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello:" + index);
                }
            };
            Thread thread = new Thread(runnable);
            thread.run();
            System.out.println("=======================================");
            thread.start();
        }
    }
}
