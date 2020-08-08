package com.yang.service;

import com.alibaba.fastjson.JSONObject;
import com.yang.annotation.ExtAnnotation;
import org.springframework.stereotype.Service;

/**
 * @Author: yang
 * @Date: 2020-06-20 23:51
 * @Description:
 */
@Service
public class AnnotationService {


    // 自定义注解 测试是使用一下
    @ExtAnnotation
    public String getExtAnnotation(JSONObject jsonObject) {
        System.out.println("json对象：" + jsonObject);
        String extAnnotation = "测试自定义注解";
        System.out.println(extAnnotation);

        // 返回的是aop里面的返回结果

        return extAnnotation;
    }
}
