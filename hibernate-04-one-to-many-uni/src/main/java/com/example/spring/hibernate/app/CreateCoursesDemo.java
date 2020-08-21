package com.example.spring.hibernate.app;


import com.example.spring.hibernate.entity.Course;
import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.nio.charset.CoderResult;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

            // start a transaction
            session.beginTransaction();

            // get the instructor from the db
            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            // create some courses
            Course course1 = new Course("Sailing the High Seas 101");
            Course course2 = new Course("How to enslave souls and keep them");

            // add courses to the instructor
            instructor.add(course1);
            instructor.add(course2);

            // save the courses
            session.save(course1);
            session.save(course2);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Finished database transaction");

        }
    }
}
