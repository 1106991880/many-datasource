package com.yang.shejimoshi.daili;

/**
 * @Author: yang
 * @Date: 2020-03-17 21:57
 * @Description: 代理模式
 */
public class TestDaili {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.add();

    }
}
