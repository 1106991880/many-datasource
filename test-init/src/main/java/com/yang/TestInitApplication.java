package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;


/**
 * @Author: yang
 * @Date: 2020-06-20 23:33
 * @Description: 学习demo测试
 * 在完成了引入AOP依赖包后，不需要去做其他配置。
 * AOP的默认配置属性中，spring.aop.auto属性默认是开启的，也就是说只要引入了AOP依赖后，
 * 默认已经增加了@EnableAspectJAutoProxy，不需要在程序主类中增加@EnableAspectJAutoProxy来启用。
 * 1.自定义注解
 * 2.集成redis
 * 3.集成activeMQ windows安装路径 D:\application_location\activemq\apache-activemq-5.16.0\bin\win64\activemq.bat双击启动即可 输入http://localhost:8161/admin访问activeMQ
 * 4.集成mybatis-plus 打印完整SQL语句
 * 5.集成swagger ui页面
 * 6.集成elastic-search客户端 最新版本7.4.2版本 , 看官方文档 使用高级客户端依赖
 * 7.集成easyexcel操作excel文件
 * 8.集成阿里云短信服务sms
 * 9.发现一个很好用的热部署插件jrebel
 */

@SpringBootApplication
@MapperScan("com.yang.mapper")//在 Spring Boot 启动类中添加 @MapperScan 注解，扫描 Mapper 文件夹
//@EnableJms// activeMQ用到
public class TestInitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestInitApplication.class, args);
    }

}
