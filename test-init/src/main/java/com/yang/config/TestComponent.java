package com.yang.config;

import com.yang.service.MapInterface;
import com.yang.service.TestInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: yang
 * @Date: 2020/12/2 下午2:31
 * @Description:
 */
@Component
public class TestComponent {

    @Value("${common.operation.login.expireTime:60}")
    private Integer dataString = 120;
    private final Map<String, MapInterface> name;
    private final List<TestInterface> testInterfaces;

    public TestComponent(Map<String, MapInterface> name, List<TestInterface> testInterfaces) {
        System.out.println("初始化name=============================" + name);
        System.out.println("testInterfaces=============================" + testInterfaces);
        this.name = name;
        this.testInterfaces = testInterfaces;
        System.out.println("111111");
        System.out.println("dataString=============================" + dataString);
        System.out.println();
    }
}
