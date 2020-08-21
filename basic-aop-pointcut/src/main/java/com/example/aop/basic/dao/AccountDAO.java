package com.example.aop.basic.dao;

import com.example.aop.basic.account.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account) {
        System.out.println(getClass() + ": DOING MY DATABASE WORK");
    }
}
