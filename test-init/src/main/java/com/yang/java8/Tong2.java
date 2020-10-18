package com.yang.java8;

/**
 * @Author: yang
 * @Date: 2020/10/16 13:44
 * @Description:
 */
class Met<T> {
    private T met;

    public void setMet(T met) {
        this.met = met;
    }

    public T getMet() {
        return this.met;
    }
}

//通配符----- ? super 类
//
//？ super 类： 表示取得泛型下限，表示泛型类只能是类和类的父类；
//？super 类 ：只能用于方法；
//？ super 类用在方法中可以设置属性值，也可以取得属性值，因为子类到父类是自动的向上转型。
//如：？ super String :表示此方法只能取得String及其父类Object类。
public class Tong2 {
    public static void main(String[] args) {
        Met<String> m1 = new Met<>();
        m1.setMet("pick");
        func(m1);  //接收String类
    }

    public static void func(Met<? super String> m) {
        // 表示 ？必须是String类的父类或者String类
        //m.setMet("world");  //可以设置属性：子类到父类是自动转型
        System.out.println(m.getMet());
    }
}