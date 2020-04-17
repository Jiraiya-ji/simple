package com.example.simple.entity;

import lombok.Data;


@Data
public class ConfigDemoBean {
    private String type = "ConfigDemoBean";

    public String getName(String name) {
        return name + " _" + type;
    }
}

