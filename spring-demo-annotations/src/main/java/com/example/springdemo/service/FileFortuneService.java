package com.example.springdemo.service;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class FileFortuneService implements FortuneService {

    private final Random myRandom = new Random();

    private List<String> fortunes = new ArrayList<>();

    private String fortune;

    @PostConstruct
    public void getFortuneFile() {
        String line;
        //try with resource
        try (BufferedReader bufferedReader = Files.newBufferedReader(ResourceUtils.getFile("D:\\Projects\\Spring\\spring-demo-annotations\\src\\main\\resources\\fortunes.txt").toPath())) {
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                fortunes.add(line);
            }
        } catch (IOException ex) {
            System.out.format("I/O exception: ", ex);
        }

        String[] fortuneArray = fortunes.toArray(String[]::new);

        int index = myRandom.nextInt(fortuneArray.length);
        fortune = fortuneArray[index];
    }

    @Override
    public String getFortune() {
        return fortune;
    }


}
