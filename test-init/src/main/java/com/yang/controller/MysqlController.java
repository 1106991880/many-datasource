package com.yang.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.entity.LearnUserInfo;
import com.yang.mapper.LearnUserInfoMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yang
 * @Date: 2020-06-14 10:52
 * @Description: mysql 查询测试
 */
@RestController
@RequestMapping("/mysql")
public class MysqlController {

    @Resource
    private LearnUserInfoMapper learnUserInfoMapper;

    @RequestMapping("/getUserInfoList")
    public String getUserInfoList(@RequestBody String json) {

        JSONObject jsonObject = JSONObject.parseObject(json);
        if (jsonObject != null) {

        }

        System.out.println(("----- selectAll method test ------"));
        List<LearnUserInfo> userList = learnUserInfoMapper.selectList(new QueryWrapper<LearnUserInfo>().eq("name", "Jack"));
        userList.forEach(System.out::println);
        return userList.toString();
    }

}
