package com.yang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: yang
 * @Date: 2020-06-20 23:31
 * @Description: 自定义注解实现 测试自定义注解的实现
 */
@Target({ElementType.METHOD})//作用的地方
@Retention(RetentionPolicy.RUNTIME)//什么时候起作用
public @interface ExtAnnotation {
}
