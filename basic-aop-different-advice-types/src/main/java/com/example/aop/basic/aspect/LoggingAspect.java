package com.example.aop.basic.aspect;

import com.example.aop.basic.account.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    // add new advice for @Around on the TrafficService
    @Around("execution(* com.example.aop.basic.service.TrafficService.trafficInfo(..))")
    public Object aroundGetTraffic(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out advising method
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @After (finally) on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = proceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute the duration and display it
        long duration = end - begin;
        System.out.println("\n====>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    // add new advice for @After on the findAccounts method
    @After("execution(* com.example.aop.basic.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out advising method
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @After (finally) on method: " + method);

    }

    // add new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.example.aop.basic.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        // print out advising method
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("====>>> Result is: " + exception);

    }

    // add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.aop.basic.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("====>>> Result is: " + result);

    }

    @Before("com.example.aop.basic.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        // loop through the arguments
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
