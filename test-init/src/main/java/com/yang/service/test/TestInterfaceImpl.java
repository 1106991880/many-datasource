package com.yang.service.test;

import com.yang.service.TestInterface;
import org.springframework.stereotype.Service;

/**
 * @Author: yang
 * @Date: 2020/12/2 下午2:48
 * @Description:
 */
@Service
public class TestInterfaceImpl implements TestInterface {
    @Override
    public String GetData() {
        System.out.println("List接口一返回的数据");
        return "List接口2返回的数据";
    }
}
