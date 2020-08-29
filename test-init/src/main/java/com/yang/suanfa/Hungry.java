package com.yang.suanfa;

/**
 * @Author: yang
 * @Date: 2020-08-26 21:39
 * @Description:
 */
public class Hungry {
    private Hungry(){

    }
    private final static Hungry hungry = new Hungry();
    public static Hungry getInstance(){
        return new Hungry();
    }

}
