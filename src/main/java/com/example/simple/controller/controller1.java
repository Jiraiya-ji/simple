package com.example.simple.controller;

import com.example.simple.service.UserService;
import com.example.simple.service.UserService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class controller1 {
    @Autowired
    private UserService1 userService;
    @GetMapping("/right2")
    public int right2(@RequestParam("name") String name) {
        try {
            userService.createUserPublic(name);
        } catch (Exception ex) {
            log.error("create user failed because {}", ex.getMessage());
        }
        return userService.getUserCount(name);
    }
}
