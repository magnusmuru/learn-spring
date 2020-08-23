package com.example.aop.basic;


import com.example.aop.basic.account.Account;
import com.example.aop.basic.config.DemoConfig;
import com.example.aop.basic.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningApp {

    public static void main(String[] args) {

        // read spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the spring bean from the container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the method to find the accounts
        List<Account> accounts = accountDAO.findAccounts(true);

        // display the accounts
        System.out.println("\nMain: AfterReturningApp");
        System.out.println(accounts);

        // close the context
        context.close();

    }
}
