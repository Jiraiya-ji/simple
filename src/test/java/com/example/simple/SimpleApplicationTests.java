package com.example.simple;

import com.example.simple.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SimpleApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        User user = context.getBean(User.class);
//        System.out.println(user.getPassword());
    }
    @Test
    public void getRedis(){
//        redisTemplate.opsForValue().set("java","我爱java");
//        String str =(String) redisTemplate.opsForValue().get("java");
//        System.out.println(str);
//        MUser mUser=new MUser();
//        mUser.setId(1);
//        mUser.setName("aa");
//        redisTemplate.opsForValue().set("user",mUser);
//        MUser user =(MUser) redisTemplate.opsForValue().get("user");
//        System.out.println(user);
    }

}
