package com.example.springdemo.coach;

import com.example.springdemo.service.FortuneService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FunCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${open.email}")
    private String email;

    @Value("${open.team}")
    private String team;

    public FunCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Have tons of fun";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

}
