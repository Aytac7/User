package com.example.user.aspect;

import jdk.jfr.Category;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public  * com.example.user.service.*.*(..))")
    public void allServiceMethods(){}

    @Before("allServiceMethods()")
    public  void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }
    @After("allServiceMethods()")
            public void logAfter(JoinPoint joinpoint){
        System.out.println("After method: " + joinpoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "allServiceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned: " + result);
    }

    @AfterThrowing(pointcut = "allServiceMethods()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("Method threw exception: " + error);
    }

    @Around("allServiceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before and after method: " + joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

}
