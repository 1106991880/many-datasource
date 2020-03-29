package com.yang.test1.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.entity.Emp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper1 extends BaseMapper<Emp> {
    @Select("select * from emp")
    public List<Emp> selectList();

    /**
     * @Return java.util.List<com.yang.entity.Emp>
     * @Description 测试mapper
     * @Param []
     */
    public List<Emp> getAll();
}
