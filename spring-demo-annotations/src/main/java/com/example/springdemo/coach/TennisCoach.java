package com.example.springdemo.coach;

import com.example.springdemo.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("fileFortuneService")
    private FortuneService fortuneService;


    public TennisCoach() {
        // System.out.println("Generating default constructor");
    }

    /*
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("Autowired setter injection");
        this.fortuneService = fortuneService;
    }
     */

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
