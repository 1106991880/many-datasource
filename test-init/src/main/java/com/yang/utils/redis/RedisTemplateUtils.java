package com.yang.utils.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yang
 * @Date: 2020-06-13 23:02
 * @Description: redis操作工具类 封装一下基本的redis操作
 */
@Component
public class RedisTemplateUtils {


    //@Autowired
    // 存入二进制的类型 这种也可以 只是不方便自己看到redis里面的值
//    @Resource
//    private RedisTemplate<String, Object> redisTemplateObject;

    // string hash list set 有序set

    @Resource
    private RedisTemplate redisTemplate;

    // 往redis里面存放数据 存对象的话 是二进制的数据
    public void setRedisObject(String key, Object value, Long timeOut) {
        redisTemplate.opsForValue().set(key, value);
        if (timeOut != null) {//超时时间不为空
            redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);//单位秒
        }
    }

    // 获取redis里面的值
    public Object getRedisObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 操作hash 放入数据
    public void setRedisHash(String key, String hashKey, String hashValue, Long timeOut) {
        redisTemplate.opsForHash().put(key, hashKey, hashValue);
        if (timeOut != null) {//超时时间不为空
            redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);//单位秒
        }
    }

    // 操作hash 获取数据
    public Object getRedisHash(String key) {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
        return entries;
    }

    // 操作hash 删除key 或者部分数据
    public void deleteRedisHashKey(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }


    // 操作redis List
    // 左右的区别在于数据怎么放 追加在后面还是前面
    public void setRedisList(String key, String operateType, List listData, Long timeOut) {
        List<String> stringList = new ArrayList<>();
        stringList.add("listValue1");
        stringList.add("listValue2");
        if (("left").equals(operateType)) {
            redisTemplate.opsForList().leftPush(key, listData);
        }
        if (("right").equals(operateType)) {
            redisTemplate.opsForList().rightPush(key, listData);
        }
        if (timeOut != null) {
            redisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        }
    }

    // 获取list里面的数据
    public Object getRedisList(String key, String operateType) {
        Object objectRedisList = null;
        if (("left").equals(operateType)) {
            objectRedisList = redisTemplate.opsForList().leftPop(key);
        }
        if (("right").equals(operateType)) {
            objectRedisList = redisTemplate.opsForList().rightPop(key);
        }
        return objectRedisList;
    }


}
