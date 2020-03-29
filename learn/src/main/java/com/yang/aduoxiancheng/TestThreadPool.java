package com.yang.aduoxiancheng;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yang
 * @Date: 2020-03-14 21:06
 * @Description: 测试线程池的创建方式
 */
public class TestThreadPool {
    public static void main(String[] args) {
        //可定长度
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        //可缓存线程池
        final ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int j = i;//因为是匿名内部类的关系
            executorService.execute(new Runnable() {
                public void run() {
                    System.out.println("线程池====" + Thread.currentThread().getName() + "," + j);
                }
            });
        }
        //可定时线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 20; i++) {
            final int j = i;
            scheduledExecutorService.schedule(new Runnable() {
                public void run() {
                    System.out.println("隔三表执行" + Thread.currentThread().getName() + "," + j);
                }
            }, 3, TimeUnit.SECONDS);//3秒之后再执行的
        }
        //单线程线程池
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        //newSingleThreadExecutor
        for (int i = 0; i < 30; i++) {
            final int j = i;
            newSingleThreadExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println("单线程线程池" + Thread.currentThread().getName() + "," + j);
                }
            });
        }
    }
}
