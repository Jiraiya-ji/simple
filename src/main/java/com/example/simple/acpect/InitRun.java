package com.example.simple.acpect;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Random;

@Component
public class InitRun implements ApplicationRunner {
    @Autowired
    DetailTransactionalSample detailTransactionalSample;
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        detailTransactionalSample.thread1();
//        detailTransactionalSample.thread2();
//        List list = new ArrayList();
//        Collections.sort(list);
//        testRedisList();
    }

    public void testRedisList(){
        String key = "list";
        long size = 10;
        RedisList redisList = new RedisList(size,key);
        //队列里添加元素
        new Thread(()->{
            while (true){
                if(redisList.getSize()>0){
                    redisList.push();
                }else {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        //队列里移除元素
        new Thread(()->{
            while (true){
                if(redisList.getSize()>=10){
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    redisList.pop();

                }
            }
        }).start();
    }
}
@Getter
class RedisList{
    private List list;
    private long size;
    private String key;
    RedisList(long size,String key){
        this.key = key;
        this.list = new RedisDemo().redisList(key,0L,size-1);
        this.size = size;
    }
    public void pop(){
        new RedisDemo().rightPopRedis(key);
        size++;
    }
    public void push(){
        new RedisDemo().leftPushRedis(key,new Random().nextInt());
        size--;
    }
}
