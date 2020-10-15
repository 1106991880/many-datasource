package com.yang.config;

import com.yang.controller.AnnotationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 下面的代码不执行的原因
// 启动的项目里面有现成处于挂起状态 比如使用activemq的时候 如果处于挂起状态 那么下面的代码就不会执行
@Component
public class StartRunConfig implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(StartRunConfig.class);
    @Override
    public void run(String... args) throws Exception {
        System.out.println("项目启动完成之后执行的方法");
    }
}
