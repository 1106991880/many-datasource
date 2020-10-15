package com.yang.fankonghui;


class TestParent {
    public int c = 1;

    public void calc(int v) {
        System.out.println("parent:" + (10 + v) / 3);
    }
}

public class Test04 extends TestParent {
    public int c = 4;

    public void calc(int v) {
        System.out.println("child:" + (10 + v) % 3);
    }

    public static void main(String[] args) {
        TestParent test04 = new Test04();
        System.out.println(test04.c);
        test04.calc(test04.c);
        TestParent test041 = new TestParent();
        System.out.println(test041.c);
        test041.calc(test041.c);
        //1
        //child:2
        //1
        //parent:3
    }
}
