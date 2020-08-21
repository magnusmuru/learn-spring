package com.example.spring.hibernate;

import com.example.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        try (factory) {
            // Get a session from the factory and begin a transaction
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve a student object
            int studentId = 1;
            Student myStudent = session.get(Student.class, studentId);

            // update name to Django
            myStudent.setFirstName("Django");

            session.getTransaction().commit();

            // New update
            session = factory.getCurrentSession();
            session.beginTransaction();

            // update email for all students
            System.out.println("Update email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();


            session.getTransaction().commit();


            System.out.println("Done!");

        }
    }
}
