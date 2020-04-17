package com.example.simple.acpect;

import com.example.simple.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {
    @Pointcut("execution(* com.example.simple.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut()&& args(user)")
    public void before(JoinPoint point, User user) {
        Object[] args = point.getArgs();
        System.out.println(user.getUserName());
        System.out.println(args);
        System.out.println("before......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning.....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing.....");
    }

    @Around("pointCut()&& args(user)")
    public void around(ProceedingJoinPoint joinPoint, User user) throws Throwable {
        System.out.println("around before ......");
//        回调目标对象的原有方法。
        joinPoint.proceed();
//        获取参数
        joinPoint.getArgs();
        System.out.println("around after ......");
    }
}
