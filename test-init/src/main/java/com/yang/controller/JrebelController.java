package com.yang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yang
 * @Date: 2020-08-07 21:04
 * @Description: 热部署插件使用 超级好用
 */
@RestController
@RequestMapping("/test")
public class JrebelController {

    @GetMapping("/test")
    public String test(){
        System.out.println("超级好用的插件啊啊 jrebel");
        System.out.println("超级好用的插件啊啊 jrebel");
        System.out.println("超级好用的插件啊啊 jrebel");
        System.out.println("超级好用的插件啊啊 jrebel");
        System.out.println("超级好用的插件啊啊 jrebel");
        System.out.println("超级好用的插件啊啊 jrebel");
        return "test 哈哈哈哈哈哈哈jrebel 超级好用的热部署插件";
    }
}
