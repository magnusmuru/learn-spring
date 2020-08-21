package com.example.spring.hibernate.app;

import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory(); factory) {
            Session session = factory.getCurrentSession();
            // create the objects

            // start a transaction
            session.beginTransaction();
            // associate the objects
            int theID = 1;
            Instructor instructor = session.get(Instructor.class, theID);

            System.out.println("Found instructor: " + instructor);
            // delete the instructor
            if (instructor != null) {
                System.out.println("Deleting: " + instructor);

                // will also delete associated "details" object
                // because of CascadeType.ALL
                session.delete(instructor);
            }
            // save the instructor

            // commit transaction
            session.getTransaction().commit();

            session.close();
            factory.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
