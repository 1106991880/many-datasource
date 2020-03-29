package com.yang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.omg.CORBA.IDLType;

/**
 * @Author: yang
 * @Date: 2020-03-08 18:22
 * @Description: springboot+mybatis-plus整合多数据源
 */
@Data
public class Emp {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
}
