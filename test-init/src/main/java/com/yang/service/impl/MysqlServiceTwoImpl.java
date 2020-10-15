package com.yang.service.impl;

import com.yang.service.MysqlService;
import org.springframework.stereotype.Service;

/**
 * @Author: yang
 * @Date: 2020/10/13 15:23
 * @Description:
 */
@Service
public class MysqlServiceTwoImpl implements MysqlService {
    @Override
    public String addOne() {
        return "addTwo";
    }
}