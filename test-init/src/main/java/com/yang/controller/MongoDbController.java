package com.yang.controller;

import com.yang.service.MongoDbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: yang
 * @Date: 2020/11/26 下午4:52
 * @Description: 操作mongodb数据库
 */
@RestController
@RequestMapping("/mongodb")
public class MongoDbController {

    @Resource
    private MongoDbService mongoDbService;

    @GetMapping("/createCollection")
    public String createCollection() {
        boolean collection = mongoDbService.createCollection();
        if (collection) {
            return "success";
        } else {
            return "fail";
        }
    }
}
