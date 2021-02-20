package com.yang.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.entity.LearnUserInfo;
import com.yang.mapper.LearnUserInfoMapper;
import com.yang.service.MysqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yang
 * @Date: 2020-06-14 10:52
 * @Description: mysql 查询测试
 */
@RestController
@RequestMapping("/mysql")
@Slf4j
public class MysqlController {

    @Resource
    private LearnUserInfoMapper learnUserInfoMapper;


    //@Qualifier("mysqlServiceOneImpl")
    // Qualifier这个注解是配合 Autowired
    @Resource(name = "mysqlServiceTwoImpl")
    private MysqlService mysqlService;

    @RequestMapping("/getOne")
    public String getOne(@RequestBody String json) {
        String s = mysqlService.addOne();
        return s;
    }

    @RequestMapping("/getUserInfoList")
    public String getUserInfoList(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        if (jsonObject != null) {
        }
        System.out.println(("----- selectAll method test ------"));
        List<LearnUserInfo> userList = learnUserInfoMapper.selectList(new QueryWrapper<LearnUserInfo>().eq("name", "Jack"));
        userList.forEach(System.out::println);
        List<LearnUserInfo> learnUserInfos = learnUserInfoMapper.selectList(new QueryWrapper<LearnUserInfo>()
                .eq("name", "jack").select("name", "age"));
        log.info("打印指定字段=======================================");
        learnUserInfos.forEach(System.out::println);
        return userList.toString();
    }

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> obj = new ConcurrentHashMap<>();
        obj.put("aa", "bb");
        obj.put("ddd","ddd");
    }

}
