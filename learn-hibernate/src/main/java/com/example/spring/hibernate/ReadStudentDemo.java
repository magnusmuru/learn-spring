package com.example.spring.hibernate;

import com.example.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        try (factory) {
            Session session = factory.getCurrentSession();
            // create a student object
            Student tempStudent = new Student("Daffy", "Duck", "disneyeatssouls@mickey.com");

            System.out.println("Creating and saving a new student...");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();

            // get new session and start transaction
            System.out.println("Getting student with id: " + tempStudent.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve student based on the id: primary key
            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);
            session.getTransaction().commit();

            System.out.println("Done!");

        }
    }
}
