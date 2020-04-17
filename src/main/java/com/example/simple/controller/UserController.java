package com.example.simple.controller;

import com.example.simple.domain.User;
import com.example.simple.mapper.UserMapper;
import com.example.simple.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUser")
    public User getUser(int id) {
        log.info("======>{}",id);
        User user =  userService.getUser(id);
        log.info("======>{}",user.toString());

        return user;
    }
    @GetMapping("wrong1")
    public int wrong1(@RequestParam("name") String name) {
        return userService.saveUser(name);
    }
    @GetMapping("ritht")
    public int right1(@RequestParam("name") String name) {
        try {
            userService.saveUser(name);
        }catch (Exception e){
            log.info("=============》{}",e.toString());
        }
        return 1;
    }
}
