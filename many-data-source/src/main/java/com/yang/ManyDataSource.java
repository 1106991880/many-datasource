package com.yang;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: yang
 * @Date: 2020-03-08 18:22
 * @Description: springboot+mybatis-plus整合多数据源+swagger-ui
 * http://localhost:8888/swagger-ui.html#/
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.yang"})
@EnableSwagger2Doc
public class ManyDataSource {
    public static void main(String[] args) {
        SpringApplication.run(ManyDataSource.class, args);
    }
}
