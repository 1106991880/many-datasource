package com.yang.service.impl;

import com.yang.service.MongoDbService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: yang
 * @Date: 2020/11/26 下午4:56
 * @Description:
 */
@Service
public class MongoDbServiceImpl implements MongoDbService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public boolean createCollection() {
        // 设置集合名称
        String collectionName = "users1";
        // 创建集合并返回集合信息
        mongoTemplate.createCollection(collectionName);
        // 检测新的集合是否存在，返回创建结果
        boolean b = mongoTemplate.collectionExists(collectionName);
        return b;
    }
}
