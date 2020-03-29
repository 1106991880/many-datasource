package com.yang.shejimoshi.simplefactory;

/**
 * @Author: yang
 * @Date: 2020-03-16 22:39
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

        CarFactory carFactory = new CarFactory();
        Car aodi = carFactory.createCar("aodi");
        aodi.run();

    }
}
