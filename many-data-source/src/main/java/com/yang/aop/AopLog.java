package com.yang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: yang
 * @Date: 2020-03-30 22:54
 * @Description: AOP面向切面编程
 * 1、execution(public * *(..)) 任意的公共方法
 * 2、execution（* set*（..）） 以set开头的所有的方法
 * 3、execution（* com.yang.annotation.LoggerApply.*（..））com.yang.annotation.LoggerApply这个类里的所有的方法
 * 4、execution（* com.yang.annotation.*.*（..））com.yang.annotation包下的所有的类的所有的方法
 * 5、execution（* com.yang.annotation..*.*（..））com.yang.annotation包及子包下所有的类的所有的方法
 * 6、execution(* com.yang.annotation..*.*(String,?,Long)) com.yang.annotation包及子包下所有的类的有三个参数，第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法
 * 7、execution(@annotation(com.yang.annotation.yang))
 */
@Aspect//标示为切面类
@Component//注入到spring的容器中
public class AopLog {

    /**
     * 定义切入点：对要拦截的方法进行定义与限制，如包、类
     * <p>
     * 1、execution(public * *(..)) 任意的公共方法
     * 2、execution（* set*（..）） 以set开头的所有的方法
     * 3、execution（* com.yang.annotation.LoggerApply.*（..））com.yang.annotation.LoggerApply这个类里的所有的方法
     * 4、execution（* com.yang.annotation.*.*（..））com.yang.annotation包下的所有的类的所有的方法
     * 5、execution（* com.yang.annotation..*.*（..））com.yang.annotation包及子包下所有的类的所有的方法
     * 6、execution(* com.yang.annotation..*.*(String,?,Long)) com.yang.annotation包及子包下所有的类的有三个参数，第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法
     * 7、execution(@annotation(com.yang.annotation.yang))
     */

    //aop编程里面的几个通知 前置通知 后置通知 运行通知 异常通知 环绕通知
    @Before("execution(* com.yang.service.*.*(..))")
    public void before() {
        System.out.println("前置通知，在方法之前执行");
    }

    //后置通知
    @After("execution(* com.yang.service.*.*(..))")
    public void after() {
        System.out.println("后置通知，在方法之后执行======");
    }

    //运行通知
    @AfterReturning("execution(* com.yang.service.*.*(..))")
    public void afterReturning() {
        System.out.println("运行通知，======");
    }

    //异常通知
    @AfterThrowing("execution(* com.yang.service.*.*(..))")
    public void afterThrowing() {
        System.out.println("异常通知，======");
    }

    //环绕通知
    @Around("execution(* com.yang.service.*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知，前======");
        proceedingJoinPoint.proceed();//代理调用方法 如果代码跑出异常 后面的代码就不会执行了
        System.out.println("环绕通知，后======");

    }

}
