package com.example.spring.hibernate.app;

import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddInstructorApp {

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

            // create an instructor
            Instructor instructor = new Instructor("Isaac", "Newton","isaac@gmail.com");

            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();
        }
    }

}
