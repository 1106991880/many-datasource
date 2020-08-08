package com.yang.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yang
 * @Date: 2020-06-13 23:11
 * @Description:
 */

@Data//如果直接存入二进制的数据到redis里面 必须实现序列化接口
public class RedisUserInfo implements Serializable {

    private String id;
    private String name;
    private Integer age;


}
