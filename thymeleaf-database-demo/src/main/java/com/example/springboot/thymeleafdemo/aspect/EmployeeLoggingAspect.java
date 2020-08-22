package com.example.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class EmployeeLoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.example.springboot.thymeleafdemo.*.*.*(..))")
    private void forControllerPackage() {
    }

    // add @Before advice
    @Before("forControllerPackage()")
    public void before(JoinPoint joinPoint) {

        // display the called method
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> in @Before: calling method: " + method);

    }

    // add @AfterReturning advice
    @AfterReturning(pointcut = "forControllerPackage()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

        // display the called method
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> in @Before: calling method: " + method);

        // display data returned
        logger.info("===> result: " + result);
    }

}
