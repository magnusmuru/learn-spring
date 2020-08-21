package com.example.spring.hibernate;

import com.example.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            // delete the student
            //System.out.println("Deleting student: " + myStudent);
            // session.delete(myStudent);

            // delete student id=2
            System.out.println("Deleting student id=2");
            session.createQuery("delete from Student where id=2").executeUpdate();


            session.getTransaction().commit();


            System.out.println("Done!");

        }
    }
}
