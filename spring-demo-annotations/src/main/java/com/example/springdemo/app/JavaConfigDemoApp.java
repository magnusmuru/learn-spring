package com.example.springdemo.app;

import com.example.springdemo.coach.Coach;
import com.example.springdemo.config.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from the spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach swimCoach = context.getBean("swimmingCoach", Coach.class);

        // call a method on the bean
        System.out.println(swimCoach.getDailyWorkout());

        // call method to get the daily fortune
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
