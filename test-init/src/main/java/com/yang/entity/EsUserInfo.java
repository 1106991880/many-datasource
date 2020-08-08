package com.yang.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: yang
 * @Date: 2020-07-25 23:58
 * @Description: es文档操作对象
 */
@Data
public class EsUserInfo {


    private String name;

    private String age;

    private Date birthDay;

    public EsUserInfo(String name, String age, Date birthDay) {
        this.name = name;
        this.age = age;
        this.birthDay = birthDay;
    }
}
