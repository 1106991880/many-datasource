package com.yang.controller;

import com.yang.entity.RedisUserInfo;
import com.yang.utils.redis.RedisTemplateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: yang
 * @Date: 2020-06-13 23:01
 * @Description: redis测试接口类
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;


    // java.lang.IllegalArgumentException:
    // DefaultSerializer requires a Serializable payload but received an
    // object of type [com.yang.entity.RedisUserInfo]
    // 要缓存的Java对象必须实现 Serializable 接口，因为 Spring 会将对象先序列化再存入Redis
    @ResponseBody
    @RequestMapping("/addUserInfo")
    public String addUserInfo() {
        System.out.println("redis jrebel是否编译");
        RedisUserInfo redisUserInfo = new RedisUserInfo();
        redisUserInfo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        redisUserInfo.setAge(20);
        redisUserInfo.setName("yang");
        //设置时间为60秒
        redisTemplateUtils.setRedisObject("userInfo", redisUserInfo, 360000L);
        redisTemplateUtils.setRedisObject("yangceshi", "哈哈哈哈", 100L);

        return "success";
    }


    // 通过key获取获取信息
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public String getUserInfo(@RequestParam("key") String key) {
        System.out.println("key：" + key);
        RedisUserInfo redisUserInfo = (RedisUserInfo) redisTemplateUtils.getRedisObject(key);
        return redisUserInfo.toString();
    }


    // PathVariable的方式解析参数
    @RequestMapping(value = "/params/{a}/{b}")
    @ResponseBody
    public String testParams(@PathVariable("a") String a, @PathVariable("b") String b) {
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        return a + b;
    }

    // RequestBody 获取请求体body里的json参数
    @RequestMapping(value = "/params2")
    @ResponseBody
    public String testParams2(@RequestBody Map<String, String> map) {
        System.out.println("获取的map参数：" + map);
        return map.toString();
    }

    // RequestBody 获取json字符串参数
    @RequestMapping(value = "/params3")
    @ResponseBody
    public String testParams3(@RequestBody String json) {
        System.out.println("获取的json字符串参数：" + json);
        return json;
    }

    // 向redis里面的存入hash结构
    @RequestMapping(value = "/redisHash")
    @ResponseBody
    public String redisHash(@RequestBody String json) {
        System.out.println("测试jrebel是否编译");
        System.out.println("测试jrebel是否编译");
        System.out.println("测试jrebel是否编译");
        System.out.println("测试jrebel是否编译");
        System.out.println("测试jrebel是否编译");
        System.out.println("测试jrebel是否编译");
        System.out.println("获取的json字符串参数：" + json);
        redisTemplateUtils.setRedisHash("hashData", "key1", "value1", 60 * 10L);
        redisTemplateUtils.setRedisHash("hashData", "key2", "value2", 60 * 10L);
        return json;
    }

    // 获取hash值
    @RequestMapping(value = "/getRedisHash")
    @ResponseBody
    public String getRedisHash(@RequestBody String json) {
        System.out.println("获取的json字符串参数：" + json);
        Object hashData = redisTemplateUtils.getRedisHash("hashData");
        return hashData.toString();
    }

    // 删除redis里面的hash值
    @RequestMapping(value = "/delRedisHash")
    @ResponseBody
    public String delRedisHash(@RequestBody String json) {
        System.out.println("获取的json字符串参数：" + json);
        redisTemplateUtils.deleteRedisHashKey("hashData", "key1");
        return json;
    }

    // 操作redis里面的list集合 存入list数据
    @RequestMapping(value = "/setRedisList")
    @ResponseBody
    public String setRedisList(@RequestBody String json) {
        List<String> strings = new ArrayList<>();
        strings.add("listValue1");
        strings.add("listValue2");
        strings.add("listValue3");
        strings.add("listValue4");
        String operateType = "left";
        redisTemplateUtils.setRedisList("listData", operateType, strings, 60 * 10L);
        return json;
    }

    // 获取redis 里面的list数据
    @RequestMapping(value = "/getRedisList")
    @ResponseBody
    public String getRedisList(@RequestBody String json) {
        System.out.println("获取redis里面的list数据：" + json);
        String operateType = "left";
        Object listData = redisTemplateUtils.getRedisList("listData", operateType);
        List<String> redisListData = (List<String>) listData;
        return redisListData.toString();
    }
}
