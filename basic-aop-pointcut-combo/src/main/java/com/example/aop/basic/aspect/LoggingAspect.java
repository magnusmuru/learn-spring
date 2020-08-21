package com.example.aop.basic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.aop.basic.*.*.*(..))")
    private void forDaoPackage() {
    }

    // create pointcut for getters & setters
    @Pointcut("execution(* com.example.aop.basic.*.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* com.example.aop.basic.*.*.set*(..))")
    private void setter() {
    }

    // combine getter and setter pointcuts
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void preformAPIAnalytics() {
        System.out.println("\n=====>>> Preforming API Analytics");
    }
}
