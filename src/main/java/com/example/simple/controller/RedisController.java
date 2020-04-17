package com.example.simple.controller;


import com.alibaba.fastjson.JSON;
import com.example.simple.acpect.InitRun;
import com.example.simple.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private User user;

    @GetMapping("/redis")
    public void redis(){

        ValueOperations ops2 = redisTemplate.opsForValue();
        ops2.set("name",user);
        User getRedis = (User) ops2.get("name");
        System.out.println(getRedis.getUserName());
    }
}
