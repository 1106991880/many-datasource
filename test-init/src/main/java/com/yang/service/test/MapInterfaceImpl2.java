package com.yang.service.test;

import com.yang.service.MapInterface;
import org.springframework.stereotype.Service;

/**
 * @Author: yang
 * @Date: 2020/12/2 下午2:53
 * @Description:
 */
@Service
public class MapInterfaceImpl2 implements MapInterface {
    @Override
    public String getMap() {
        System.out.println("map2返回值========================");
        return "map2";
    }
}
