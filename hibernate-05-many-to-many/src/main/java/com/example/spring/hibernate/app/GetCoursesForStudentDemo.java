package com.example.spring.hibernate.app;


import com.example.spring.hibernate.entity.Course;
import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import com.example.spring.hibernate.entity.Review;
import com.example.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

            // start a transaction
            session.beginTransaction();

            // get the student from the database
            int studentId = 2;
            Student student = session.get(Student.class, studentId);

            System.out.println("\nLoaded student: " + student);
            System.out.println("\nCourses: " + student.getCourses());



            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Finished database transaction");

        }
    }
}
