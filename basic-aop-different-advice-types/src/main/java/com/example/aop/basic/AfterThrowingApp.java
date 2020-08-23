package com.example.aop.basic;


import com.example.aop.basic.account.Account;
import com.example.aop.basic.config.DemoConfig;
import com.example.aop.basic.dao.AccountDAO;
import com.example.aop.basic.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingApp {

    public static void main(String[] args) {

        // read spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the spring bean from the container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the method to find the accounts
        List<Account> accounts = null;
        try {
            boolean tripwire = true;
            accounts = accountDAO.findAccounts(tripwire);
        } catch (Exception exception) {
            System.out.println("\nMain Program ... caught exception " + exception);
        }


        // display the accounts
        System.out.println("\nMain: AfterReturningApp");
        System.out.println(accounts);

        // close the context
        context.close();

    }
}
