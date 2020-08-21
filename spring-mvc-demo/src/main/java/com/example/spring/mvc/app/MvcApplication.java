package com.example.spring.mvc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.spring.mvc"})
@PropertySources({
        @PropertySource("classpath:studentform.properties"),
        @PropertySource("classpath:messages.properties")})

public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

}
