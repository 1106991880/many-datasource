package com.yang.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: yang
 * @Date: 2020-06-14 10:50
 * @Description:
 */
@Data
@TableName("learn_user_info")//对于数据库的表名
public class LearnUserInfo {
    @TableField(value = "id")
    private Long id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private Integer age;
    @TableField(value = "email")
    private String email;
    @TableField(exist = false)//不为数据库的字段
    private String userItemList;
}
