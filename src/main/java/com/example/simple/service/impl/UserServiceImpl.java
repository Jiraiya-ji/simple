package com.example.simple.service.impl;

import com.example.simple.domain.User;
import com.example.simple.mapper.UserMapper;
import com.example.simple.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("User 为空！");
        }
        System.out.println(user.getId());
        System.out.println(user.getPassword());
        System.out.println(user.getUserName());
    }

    @Override
    public User getUser(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public int saveUser(String name) {
        try {
            this.createUser(name);
        }catch (Exception e){
            log.error("create user failed because {}", e.getMessage());
        }
        return userMapper.queryCountOfUserByName(name);
    }
    @Override
    @Transactional
    public void createUser(String name){
        userMapper.saveUserByName(name);
        if(name.equals("test")){
            throw new RuntimeException("invalid username!");
        }
    }
}
