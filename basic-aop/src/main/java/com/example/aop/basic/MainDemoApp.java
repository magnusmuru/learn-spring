package com.example.aop.basic;


import com.example.aop.basic.account.Account;
import com.example.aop.basic.config.DemoConfig;
import com.example.aop.basic.dao.AccountDAO;
import com.example.aop.basic.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the spring bean from the container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        accountDAO.addAccount(new Account());

        // call the membership method
        membershipDAO.addAccount();

        // close the context
        context.close();

    }
}
