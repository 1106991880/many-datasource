package com.yang.aop;

import com.yang.annotation.ExtAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yang
 * @Date: 2020-06-20 23:33
 * @Description: aop 实现自定义注解或打印日志等
 * 1、execution(public * *(..)) 任意的公共方法
 * 2、execution（* set*（..）） 以set开头的所有的方法
 * 3、execution（* com.yang.annotation.LoggerApply.*（..））com.yang.annotation.LoggerApply这个类里的所有的方法
 * 4、execution（* com.yang.annotation.*.*（..））com.yang.annotation包下的所有的类的所有的方法
 * 5、execution（* com.yang.annotation..*.*（..））com.yang.annotation包及子包下所有的类的所有的方法
 * 6、execution(* com.yang.annotation..*.*(String,?,Long)) com.yang.annotation包及子包下所有的类的有三个参数，第一个参数为String类型，第二个参数为任意类型，第三个参数为Long类型的方法
 * 7、execution(@annotation(com.yang.annotation.yang))
 */
@Aspect
@Component
public class ExtAop {

    private static final Logger log = LoggerFactory.getLogger(ExtAop.class);

    // aop编程里面的几个通知 前置通知 后置通知 运行通知 异常通知 环绕通知
    @Before("execution(* com.yang.service.*.*(..))")
    public void before() {
        System.out.println("前置通知，在方法之前执行");
    }

    // 后置通知
    @After("execution(* com.yang.service.*.*(..))")
    public void after() {
        System.out.println("后置通知，在方法之后执行======");
    }

    // 运行通知
    @AfterReturning("execution(* com.yang.service.*.*(..))")
    public void afterReturning() {
        System.out.println("运行通知，======");
    }

    // 异常通知
    @AfterThrowing("execution(* com.yang.service.*.*(..))")
    public void afterThrowing() {
        System.out.println("异常通知，======");
    }

    // 自定义注解的具体实现 测试具体实现 环绕通知
    @Around("execution(* com.yang.service.*.*(..))")
    public String around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取代理对象的具体方法
        // 获取方法名称
        String name = pjp.getSignature().getName();

        log.info("自定义注解获取的方法名：" + name);

        // 获取目标对象
        Class<?> aClass = pjp.getTarget().getClass();
        log.info("获取目标对象：" + aClass);
        // 获取目标对象类型
        Class[] parameterTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();

        log.info("获取目标对象：" + parameterTypes);

        //获取目标对象方法
        Method objMethod = aClass.getMethod(name, parameterTypes);

        log.info("获取目标对象方法：" + objMethod);

        int parameterCount = objMethod.getParameterCount();
        log.info("获取目标方法的参数个数：" + parameterCount);

        // 获取参数名和参数值
        Map<String, Object> nameAndValue = getNameAndValue(pjp);
        nameAndValue.forEach((k, v) -> {
            log.info("遍历获取的目标方法的参数类型和参数值,参数名：" + k + "参数值：" + v);
        });

        // 获取注解
        // 获取方法上面是否加注解
        // 如果存在事物注解 就添加事物
        ExtAnnotation declaredAnnotation = objMethod.getDeclaredAnnotation(ExtAnnotation.class);

        log.info("获取注解：" + declaredAnnotation);

        if (declaredAnnotation == null) {
            log.info("目标方法上面无注解");
        } else {
            // 执行你的操作
            log.info("目标方法上面有注解");
            // 执行你的自定义操作
        }
        // 执行代理方法的操作
        Object proceed = pjp.proceed();

        System.out.println("执行目标方法返回的结果：" + proceed.toString());

        // 调用目标代理对象的方法
        if (declaredAnnotation != null) {
            log.info("有注解后续操作");
        } else {
            log.info("无注解后续操作");
        }

        return proceed.toString();

    }


    // 获取方法的参数的名称和值
    Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>();
        // 参数值
        Object[] paramValues = joinPoint.getArgs();
        // 参数名
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }

        return param;
    }
}
