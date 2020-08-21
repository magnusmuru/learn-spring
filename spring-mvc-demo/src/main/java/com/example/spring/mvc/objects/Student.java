package com.example.spring.mvc.objects;

import lombok.Getter;
import lombok.Setter;

public class Student {

    @Getter
    @Setter
    public String firstName;

    @Getter
    @Setter
    public String lastName;

    @Getter
    @Setter
    public String country;

    @Getter
    @Setter
    public String programmingLanguage;

    @Getter
    @Setter
    public String[] operatingSystem;

    public Student() {

    }
}
