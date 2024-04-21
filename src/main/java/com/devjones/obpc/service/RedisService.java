package com.devjones.obpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public String getValues(String key){
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        return values.get(key);
    }



    public void setValues(String key, String value){
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(key,value);
    }
}
