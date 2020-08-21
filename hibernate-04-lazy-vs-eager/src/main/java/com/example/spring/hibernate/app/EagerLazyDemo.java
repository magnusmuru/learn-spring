package com.example.spring.hibernate.app;


import com.example.spring.hibernate.entity.Course;
import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

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

            System.out.println("Instructor: " + instructor);
            System.out.println("Courses: " + instructor.getCourses());

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Finished database transaction");

            session.close();
        }
        factory.close();
    }
}
