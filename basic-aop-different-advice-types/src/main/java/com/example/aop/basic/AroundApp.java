package com.example.aop.basic;


import com.example.aop.basic.account.Account;
import com.example.aop.basic.config.DemoConfig;
import com.example.aop.basic.dao.AccountDAO;
import com.example.aop.basic.service.TrafficService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundApp {

    public static void main(String[] args) {

        // read spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the spring bean from the container
        TrafficService trafficService =  context.getBean("trafficService", TrafficService.class);

        System.out.println("\nMain program: AroundApp");
        System.out.println("Calling getTraffic");

        String data = trafficService.trafficInfo();

        System.out.println("\nThe traffic is: " + data);
        System.out.println("Finished");

        // close the context
        context.close();

    }
}
