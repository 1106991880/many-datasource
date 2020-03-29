package com.yang.test2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.entity.Emp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yang
 * @Date: 2020-03-08 18:22
 * @Description: springboot+mybatis-plus整合多数据源
 */
@Repository
public interface EmpMapper2  extends BaseMapper<Emp> {
    @Select("select * from emp")
    public List<Emp> selectList();

    /**
     * 测试mapper
     * @return
     */
    public List<Emp> getAll();
}
