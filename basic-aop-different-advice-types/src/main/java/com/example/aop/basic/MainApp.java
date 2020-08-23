package com.example.aop.basic;


import com.example.aop.basic.account.Account;
import com.example.aop.basic.config.DemoConfig;
import com.example.aop.basic.dao.AccountDAO;
import com.example.aop.basic.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // read spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the spring bean from the container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account account = new Account();
        accountDAO.addAccount(account);

        // call the membership method
        membershipDAO.addAccount();

        // add account getters and setters
        account.setName("Steve");
        account.setLevel("Intermediate");

        // close the context
        context.close();

    }
}
