package com.example.spring.hibernate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database" + jdbcUrl);

            Connection myConnection = DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SpringApplication.run(HibernateApplication.class, args);
    }

}
