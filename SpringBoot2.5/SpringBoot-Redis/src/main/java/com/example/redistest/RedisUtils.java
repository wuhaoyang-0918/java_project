package com.example.redistest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author why
 * @date 2021/10/28 10:30
 * @PackageName com.example.redistest
 * @description  序列化和反序列化方式(json格式)
 */
@Component
public class RedisUtils {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setString(String key,String value,Long timeOut){
       // redisTemplate.opsForValue().set(key,value,timeOut,TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key,value);
        if (timeOut != null) {
            //设置key的过期时间
            redisTemplate.expire(key,timeOut,TimeUnit.SECONDS);
        }


    }
    public String getString(String key){
       return redisTemplate.opsForValue().get(key);
    }

}
