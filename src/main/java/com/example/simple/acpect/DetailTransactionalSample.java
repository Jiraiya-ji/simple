package com.example.simple.acpect;

import com.example.simple.service.UserService3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class DetailTransactionalSample {
    @Autowired
    private UserService3 userService3;
    //线程一  改数据
    public void thread1(){
        new Thread(()->{
            try {
                log.info("线程一在执行");
                userService3.updateId(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    //线程二 读
    public void thread2(){
        new Thread(()->{
            try {
                log.info("线程二在执行");
                userService3.selectId();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
