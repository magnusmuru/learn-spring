package com.example.spring.hibernate.app;


import com.example.spring.hibernate.entity.Course;
import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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

            // create the objects
            Instructor instructor = new Instructor("Davy", "Jones", "krakenschool@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("youtube.com/flyingdutchmanCREW", "sailing");

            // associate the objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor object
            session.save(instructor);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Finished database transaction");

        }
    }
}
