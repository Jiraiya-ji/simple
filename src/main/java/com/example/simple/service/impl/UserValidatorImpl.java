package com.example.simple.service.impl;

import com.example.simple.domain.User;
import com.example.simple.service.UserValidator;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validator(User user) {
        System.out.println("引入新接口" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
