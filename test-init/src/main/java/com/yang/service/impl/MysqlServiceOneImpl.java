package com.yang.service.impl;

import com.yang.service.MysqlService;
import org.springframework.stereotype.Service;

/**
 * @Author: yang
 * @Date: 2020/10/13 15:23
 * @Description: Service的名称默认按照小写操作
 */
@Service
public class MysqlServiceOneImpl implements MysqlService {
    @Override
    public String addOne() {
        return "addOne";
    }
}