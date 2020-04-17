package com.example.simple.service;

import com.example.simple.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService2 {
    @Autowired
    private UserMapper userMapper;
    public void insertUser(){
//        userMapper.saveUserByName("child");
        throw new RuntimeException("error");
    }
}
