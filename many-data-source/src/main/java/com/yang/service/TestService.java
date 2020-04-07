package com.yang.service;

import com.yang.annotation.ExtTransaction;
import org.springframework.stereotype.Service;

/**
 * @Author: yang
 * @Date: 2020-03-30 23:01
 * @Description:
 */
@Service
public class TestService {


    //测试aop
    @ExtTransaction//自定义的注解
    public String testAop() {
        System.out.println("测试AOP执行成功");
        return "测试aop成功";
    }
}
