package com.example.springdemo.app;

import com.example.springdemo.coach.Coach;
import com.example.springdemo.coach.FunCoach;
import com.example.springdemo.config.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FunConfigDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from the spring container
        FunCoach theCoach = context.getBean("funCoach", FunCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        // call out new getEmail and get Team methods
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());

        // close the context
        context.close();
    }
}
