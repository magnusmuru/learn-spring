package com.example.aop.basic.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficService {

    public String trafficInfo() {
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        // return a String
        return "World is ending, there is no traffic";
    }
}
