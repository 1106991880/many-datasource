package com.yang.controller;

import com.yang.entity.Emp;
import com.yang.service.TestService;
import com.yang.test1.dao.EmpMapper1;
import com.yang.test2.dao.EmpMapper2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: yang
 * @Date: 2020-03-08 18:22
 * @Description: 测试多数据源
 */
@RestController
@Api("测试多数据源接口")
public class TestController {
    @Autowired
    private EmpMapper1 empMapper1;
    @Autowired
    private EmpMapper2 empMapper2;

    @Autowired
    private TestService testService;

    @GetMapping("/testAop")
    public String testAop() {
        String testAop = testService.testAop();
        return testAop;
    }

    @ApiOperation("测试mybatis@select注解，通过test1数据库实现")
    @GetMapping("/getKing1")
    public List getKing1() {
        List<Emp> emps = empMapper1.selectList();
        return emps;
    }


    @ApiOperation("测试mybatis@select注解，通过test2数据库实现")
    @GetMapping("/getKing2")
    public List getKing2() {
        List<Emp> emps = empMapper2.selectList();
        return emps;
    }


    @ApiOperation("测试mybatis的mapper.xml文件调用，通过test1数据库实现")
    @GetMapping("/getKing3")
    public List getKing3() {
        List<Emp> emps = empMapper1.getAll();
        return emps;
    }


    @ApiOperation("测试mybatis的mapper.xml文件调用，通过test2数据库实现")
    @GetMapping("/getKing4")
    public List getKing4() {
        List<Emp> emps = empMapper2.getAll();
        return emps;
    }


    @ApiOperation("通过mp调用test1数据库实现查询")
    @GetMapping("/getKing5")
    public List getKing5() {
        List<Emp> emps = empMapper1.selectList(null);
        return emps;
    }


    @ApiOperation("通过mp调用test2数据库实现查询")
    @GetMapping("/getKing6")
    public List getKing6() {
        List<Emp> emps = empMapper2.selectList(null);
        return emps;
    }


}
