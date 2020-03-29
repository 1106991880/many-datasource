package com.yang.shejimoshi.cglibproxy;

import com.yang.shejimoshi.daili.UserDaoImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: yang
 * @Date: 2020-03-17 22:29
 * @Description:
 */
public class TestCglibProxy implements MethodInterceptor {
    private Object targetObj;

    public Object getInstance(Object target) {
        this.targetObj = target;
        //操作字节码 生成子类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理开始");
        Object invoke = methodProxy.invoke(targetObj, objects);
        System.out.println("cglib动态代理结束");
        return invoke;
    }

    public static void main(String[] args) {
        TestCglibProxy testCglibProxy = new TestCglibProxy();
        UserDaoImpl userDao = (UserDaoImpl) testCglibProxy.getInstance(new UserDaoImpl());
        userDao.add();
    }

}
