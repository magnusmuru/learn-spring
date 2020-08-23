package com.example.aop.basic.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Account {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String level;

}
