package com.example.simple.mapper;

import com.example.simple.domain.User;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Select("select * from t_user where id = #{id}")
    User queryUserById(@Param(value = "id") int id);

    @Select("select count(*) from t_user where userName = #{name}")
    int queryCountOfUserByName(@Param(value = "name") String name);

    @Insert("INSERT INTO  t_user (userName, password) VALUES(#{name},'3') ")
    void saveUserByName(@Param(value = "name") String name);

    @Update("UPDATE t_user SET PASSWORD = #{id} WHERE id = 11")
    void updateUserPassword(@Param(value = "id")int id);

    @Select("SELECT PASSWORD FROM t_user WHERE id =11")
    int returnId();
}