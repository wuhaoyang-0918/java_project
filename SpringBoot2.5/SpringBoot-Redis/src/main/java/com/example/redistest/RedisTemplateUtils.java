package com.example.redistest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author why
 * @date 2021/10/28 11:31
 * @PackageName com.example.redistest
 * @description
 */
@Component
public class RedisTemplateUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setObject(String key,Object value,Long timeOut){
        // redisTemplate.opsForValue().set(key,value,timeOut,TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(key,value);
        if (timeOut != null) {
            //设置key的过期时间
            redisTemplate.expire(key,timeOut, TimeUnit.SECONDS);
        }


    }
    public Object getObject(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
