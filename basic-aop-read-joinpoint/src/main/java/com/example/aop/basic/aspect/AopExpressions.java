package com.example.aop.basic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.example.aop.basic.*.*.*(..))")
    public void forDaoPackage() {
    }

    // create pointcut for getters & setters
    @Pointcut("execution(* com.example.aop.basic.*.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.example.aop.basic.*.*.set*(..))")
    public void setter() {
    }

    // combine getter and setter pointcuts
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }
}
