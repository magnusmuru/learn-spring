package com.example.aop.basic.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class APIAnalyticsAspect {
    @Before("com.example.aop.basic.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void APIAnalyticsAspect() {
        System.out.println("\n=====>>> Preforming API analytics");
    }
}
