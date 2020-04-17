package com.example.simple.service;

import com.example.simple.domain.User;

public interface UserService {
    void printUser(User user);
    User getUser(int id);
    int saveUser(String name);
    void createUser(String name);
}
