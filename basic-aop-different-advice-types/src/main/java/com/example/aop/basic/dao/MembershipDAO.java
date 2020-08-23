package com.example.aop.basic.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {

        System.out.println(getClass() + ": ADDING A MEMBERSHIP ACCOUNT");
    }
}
