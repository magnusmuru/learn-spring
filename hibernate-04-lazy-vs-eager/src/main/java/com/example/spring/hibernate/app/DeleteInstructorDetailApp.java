package com.example.spring.hibernate.app;

import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailApp {

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

            // get the instructor detail object
            int theID = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);

            // print the instructor detail
            System.out.println("InstructorDetail: " + instructorDetail);

            // print the associated instructor

            instructorDetail.getInstructor().setInstructorDetail(null);

            // delete the instructor detail
            System.out.println("Deleting instructor detail" + instructorDetail);
            session.delete(instructorDetail);

            // commit transaction
            session.getTransaction().commit();
        }
    }

}
