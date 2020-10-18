package com.yang.java8;

/**
 * @Author: yang
 * @Date: 2020/10/16 13:39
 * @Description:
 */

class Mess<T extends Number>  //T只能是Number及其子类
{
    private T mess;

    public void setMess(T mess) {
        this.mess = mess;
    }

    public T getMess() {
        return this.mess;
    }
}

public class Tong1 {

    public static void main(String[] args) {
        //Mess<String> m1=new Mess<String>();  //错误，因为String不是Number的子类
        Mess<Integer> m2 = new Mess<>();
        m2.setMess(10);  //自动装箱
        func(m2);

        Mess<Double> m3 = new Mess<>();
        m3.setMess(19.3);
        func(m3);
    }

    public static void func(Mess<? extends Number> m) {
        //?必须是Number的子类 或者Number
        //此时？继承了Number类，但依旧不知道具体类型，即无法修改数据
        //m.setMess(10);//错误
        System.out.println(m.getMess());
    }
}