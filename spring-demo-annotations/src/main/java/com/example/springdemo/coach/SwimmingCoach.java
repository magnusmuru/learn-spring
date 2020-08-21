package com.example.springdemo.coach;

import com.example.springdemo.service.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${open.email}")
    private String email;

    public SwimmingCoach() {

    }

    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim five 50m sprints";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
