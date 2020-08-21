package com.example.springdemo.app;

import com.example.springdemo.coach.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

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
