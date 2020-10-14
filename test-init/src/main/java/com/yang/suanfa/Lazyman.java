package com.yang.suanfa;

/**
 * @Author: yang
 * @Date: 2020-08-26 21:39
 * @Description: 计模式-单例设计模式之懒汉式
 */
public class Lazyman {

    private Lazyman() {
    }

    private static Lazyman lazyman;

    public static Lazyman getInstance() {
        if (lazyman == null) {
            synchronized (Lazyman.class) {
                if (lazyman == null) {
                    return new Lazyman();
                }
            }
        }
        return lazyman;
    }

}
