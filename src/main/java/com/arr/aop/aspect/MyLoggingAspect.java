package com.arr.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
    Logger logger = LoggerFactory.getLogger(MyLoggingAspect.class);
    @Before("execution(* com.arr.aop.aspect.AspectServiceImpl.add(..))")
    public void logEntry() {
        logger.trace(">> add method called");
    }

    @After("execution(* com.arr.aop.aspect.AspectServiceImpl.add(..))")
    public void logExit() {
        logger.trace("<< add method returned");
    }

    @Around("execution(* com.arr.aop.aspect.AspectServiceImpl.add(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Invoke the original method
        long executionTime = System.currentTimeMillis() - startTime;

        logger.trace("Rahul time tracker : Method " + joinPoint.getSignature() + " took " + executionTime + "ms");

        return result; // Return the original method's result
    }

    @Before("execution(* com.arr.aop.rest.AspectController.registeredBeans())")
    public void testAspect() {
        System.out.println("Beans method called!");
    }
}
