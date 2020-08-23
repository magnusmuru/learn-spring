package com.example.aop.basic.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String level;

}
