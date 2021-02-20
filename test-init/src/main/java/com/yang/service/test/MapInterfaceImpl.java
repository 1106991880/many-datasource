package com.yang.service.test;

import com.yang.service.MapInterface;
import org.springframework.stereotype.Service;

/**
 * @Author: yang
 * @Date: 2020/12/2 下午2:53
 * @Description:
 */
@Service
public class MapInterfaceImpl implements MapInterface {
    @Override
    public String getMap() {
        System.out.println("map1返回值========================");
        return "map1";
    }
}
