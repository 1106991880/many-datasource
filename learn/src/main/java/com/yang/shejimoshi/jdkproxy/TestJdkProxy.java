package com.yang.shejimoshi.jdkproxy;

import com.yang.shejimoshi.daili.UserDao;
import com.yang.shejimoshi.daili.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: yang
 * @Date: 2020-03-17 22:09
 * @Description: 测试jdk 动态代理
 */
public class TestJdkProxy implements InvocationHandler {
    private Object target;

    public TestJdkProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行");
        Object invoke = method.invoke(target, args);
        System.out.println("方法之后执行");
        return invoke;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        TestJdkProxy testJdkProxy = new TestJdkProxy(userDao);
        //获取类加载器
        ClassLoader classLoader = userDao.getClass().getClassLoader();
        //获取实现的接口
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        UserDao userDao1 = (UserDao) Proxy.newProxyInstance(classLoader, interfaces, testJdkProxy);
        userDao1.add();
    }
}
