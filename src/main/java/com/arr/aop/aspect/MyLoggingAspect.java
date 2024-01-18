//package com.arr.aop.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class MyLoggingAspect {
//
//    Logger logger = LoggerFactory.getLogger(MyLoggingAspect.class);
//
//    @Around("logAround()")
//    public void logAroundMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        String methodName = proceedingJoinPoint.getSignature().getName();
//        logger.trace(">> {}", methodName);
//        proceedingJoinPoint.proceed();
//        logger.trace("<< {}", methodName);
//    }
//
//    @Pointcut("execution(public * *(..))")
//    public void logAround() {
//    }
//}
