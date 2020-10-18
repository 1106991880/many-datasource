package com.yang.java8;

import org.apache.poi.ss.formula.functions.T;

class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
//通配符-----？
//
//？通配符：表示参数可以接收任意类型 ，只能用于方法。

public class Tong {
    public static void main(String[] args) {
        Message<String> m1 = new Message<>();
        m1.setMessage("pick");
        func(m1);

        Message<Integer> m2 = new Message<>();
        m2.setMessage(10);
        func(m2);  //这里会出错，如果func形参指定类型，就要重载一个形参为Integer的func

    }

    public static void func(Message<?> m) {
        //此时使用通配符"?"描述的是它可以接收任意类型，但是由于不确定类型，所以无法修改
        //m.setMessage("world"); //错误，不能修改数据
        System.out.println(m.getMessage());
    }
    //通配符----？ extends 类
    //
    //？ extends 类 是设置泛型上限，表示泛型类是类或者类的子类；
    //？ extends 类 可以用于类和方法
    //? extends 类用于方法时，不能修改属性值，只能取得属性值，因为发生了父类（如Number）到子类的向下转型，需要强转，由于子类不确定，无法强转。
    //如：? extends Number 表示只能设置Number及其子类如Integer 、Double等。
    //T extends 类 ： 用在类上
    //表示T只能是类或类的子类。
    //
    //？extends 类： 用在方法上
    //表示只能接受类及其子类的泛型类。






}
