package com.example.spring.mvchibernate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// Component scan is required on the main application to find controllers/entities/etc
@ComponentScan(basePackages = {"com.example.spring.mvchibernate"})
@PropertySources({
        @PropertySource("classpath:application.properties")})
@EnableTransactionManagement
public class MvcHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcHibernateApplication.class, args);
    }
}
