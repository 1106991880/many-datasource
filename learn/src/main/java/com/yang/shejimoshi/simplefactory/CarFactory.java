package com.yang.shejimoshi.simplefactory;

/**
 * @Author: yang
 * @Date: 2020-03-16 22:39
 * @Description:
 */
public class CarFactory {

    public Car  createCar(String name) {

        if (name.equals("aodi")){
            return new aodiCarFactory();
        }
        return null;

    }
}
