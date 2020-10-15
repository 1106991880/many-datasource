package com.yang.fankonghui;

class Test11 {
    private static String name = "test01";

    public Test11() {
        name = "parent";
    }

    static {
        name = "static parent";
    }
}


class TestChildren extends Test11 {
    private static String name = "test01";

    public TestChildren() {
        name = "child";
    }

    static {
        name = "static child";
    }

    public static void main(String[] args) {
        TestChildren testChildren = new TestChildren();
        System.out.println(testChildren.name);
    }
}
