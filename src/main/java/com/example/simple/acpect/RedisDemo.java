package com.example.simple.acpect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *  redis demo
 */
@Slf4j
public class RedisDemo {

    @Autowired
    private RedisTemplate redisTemplate;

    public void setRedis(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
        }catch (Exception e){
            log.info("redis 存放值发生了异常 {}",e);
        }
    }

    public Object getRedis(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    public void expireKey(String key, long time, TimeUnit timeUnit){
        redisTemplate.expire(key,time,timeUnit);
    }

    public List<Object> redisList(String key,long start,long end){
        return redisTemplate.opsForList().range(key,start,end);
    }

    public void leftPushRedis(String key,Object value){
        redisTemplate.opsForList().leftPush(key,value);
    }

    public void rightPopRedis(String key){
        redisTemplate.opsForList().rightPop(key);
    }
}
