package com.example.springdemo.config;

import com.example.springdemo.coach.Coach;
import com.example.springdemo.coach.FunCoach;
import com.example.springdemo.service.FortuneService;
import com.example.springdemo.service.SadFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.example.springdemo")
@PropertySource("classpath:application.properties")
public class SportConfig {

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our swim coach and inject dependency
    @Bean
    public Coach funCoach() {
        return new FunCoach(sadFortuneService());
    }

}
