package com.yang.constants;

import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yang
 * @Date: 2021/1/15 下午1:03
 * @Description:
 */
public class TestContanst {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("A", "A");
        map.put("EA", "A");
        map.put("B", "B");
        map.put("EB", "B");
        map.put("C1", "C");
        map.put("C2", "C");
        map.put("C3", "C");
        map.put("EC", "C");
        map.put("D1", "D");
        map.put("D2", "D");
    }

    public static Map<String,String> getMap(){
        return map;
    }
}
