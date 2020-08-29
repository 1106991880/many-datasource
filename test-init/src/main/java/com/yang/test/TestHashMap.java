package com.yang.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Author: yang
 * @Date: 2020-07-02 10:37
 * @Description:
 */
public class TestHashMap {


    public static void main(String[] args) {
        Map<String,String> map= new HashMap<>();
        map.put(null,"data");
        map.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
        List<Object> listData = new ArrayList<>();
        listData.add(null);


        ThreadLocal<Object> threadLocal = new ThreadLocal<>();


        Object o = threadLocal.get();

        threadLocal.remove();

        //threadLocal.set();


        //synchronized ()

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);



    }



}
