package com.yang.controller;

import com.alibaba.fastjson.JSONObject;
import com.yang.service.AnnotationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: yang
 * @Date: 2020-06-20 23:44
 * @Description: 测试自定义注解和aop
 */
@RestController
@RequestMapping("/annotation")
@Api("自定义注解")
public class AnnotationController {

    @Autowired
    private AnnotationService annotationService;


    private static final Logger log = LoggerFactory.getLogger(AnnotationController.class);

    @ApiOperation("自定义注解测试")
    @PostMapping("/getExtAnnotation")
    public String getExtAnnotation(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        if (jsonObject != null) {
            log.info("获取的参数：" + jsonObject);
        }
        String result = annotationService.getExtAnnotation(jsonObject);

        System.out.println("result===" + result);


        // result="123";

        return result;
    }

}
