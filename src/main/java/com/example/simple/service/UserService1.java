package com.example.simple.service;


import com.example.simple.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserService1 {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService2 userService2;

    //一个公共方法供Controller调用，内部调用事务性的私有方法
    public int createUserWrong1(String name) {
        createUserPublic(name);
        return userMapper.queryCountOfUserByName(name);
    }

    @Transactional
    public void createUserPublic(String name) {
        userMapper.saveUserByName(name);
        userService2.insertUser();
//        try {
//        }catch (Exception e){
//            log.info("子事务出了异常 {}",e);
//        }
    }

    //根据用户名查询用户数
    public int getUserCount(String name) {
        return userMapper.queryCountOfUserByName(name);
    }
}