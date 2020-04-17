package com.example.simple.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Slf4j
@RestController
public class TestConcurrentHashMap {
    //线程数量
    private static int THREAD_COUNT = 10;
    //元素数量
    private static int TIME_COUNT = 1000;

    private static ConcurrentHashMap<String, Long> concurrentHashMap;
    //填充
    private ConcurrentHashMap<String,Long> getData(int count){
        return LongStream.rangeClosed(1,count)
                .boxed()
                .collect(Collectors.toConcurrentMap(
                        i-> UUID.randomUUID().toString(), Function.identity(),
                        (o1,o2)->o1,ConcurrentHashMap::new));
    }

    @GetMapping("wrong")
    public String wrong() throws InterruptedException {
        //初始900个元素
        concurrentHashMap = getData(TIME_COUNT - 100);
        log.info("init size:{}", concurrentHashMap.size());
        int gap = TIME_COUNT - concurrentHashMap.size();
        log.info("gap size:{}", gap);
        //补充元素
        concurrentHashMap.putAll(getData(gap));
        log.info("finish size:{}", concurrentHashMap.size());
        return "OK";
    }
    public static void main(String[] args)throws InterruptedException{
        testForkJoinPool();
//        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
//        forkJoinPool.execute(()->IntStream.rangeClosed(1,10).parallel().forEach(
//                i->{
//                    log.info("1");
//                    System.out.println(88);
//                }
//        ));
//        forkJoinPool.execute(()->log.info("1"));
//        forkJoinPool.shutdown();
    }
    public static void testForkJoinPool()throws InterruptedException
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);

//        forkJoinPool.execute(()->IntStream.rangeClosed(1,10).parallel().forEach(
//                i->{
//                    log.info("{}",i);
//                }
//        ));
        forkJoinPool.execute(()-> log.info("12"));
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);

    }
}
