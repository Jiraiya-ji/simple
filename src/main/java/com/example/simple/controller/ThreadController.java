package com.example.simple.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

@RestController
public class ThreadController {
    //创建一个本地线程
    private static final ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> null);
    @RequestMapping("/threadTest")
    public Map getUser(@Param("userId")Integer userId){
        String before = Thread.currentThread().getName()+":"+integerThreadLocal.get();
        integerThreadLocal.set(userId);
        String after = Thread.currentThread().getName() + ":" + integerThreadLocal.get();
        Map map = new HashMap();
        map.put("before ： ",before);
        map.put("after ： ",after);
        return map ;
    }

}
