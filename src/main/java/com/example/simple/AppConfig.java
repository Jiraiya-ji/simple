package com.example.simple;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {
//    @Bean(name = "dataSource")
//    public DataSource getDataSource(){
//        Properties properties = new Properties();
//        properties.setProperty("driver","com.mysql.dbc.Driver");
//        properties.setProperty("url","jdbc:mysql://localhost:3306/chapter3");
//        properties.setProperty("username","root");
//        properties.setProperty("password","root");
//        DataSource dataSource = null;
//        try{
//            dataSource= BasicDataSourceFactory.createDataSource(properties);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return dataSource;
//    }

}