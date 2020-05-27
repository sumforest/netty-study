package com.sen.netty.study.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: Sen
 * @date 2020/5/26 0026 14:55
 * @description:
 */
@Service
public class RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    private ValueOperations<String,String> valueOperations;

    public void saveString(String key, String value) {
        valueOperations.set(key, value);
    }

    public String getString(String key) {
        return valueOperations.get(key);
    }

    public void deleteString(String key) {
        stringRedisTemplate.delete(key);
    }

}
