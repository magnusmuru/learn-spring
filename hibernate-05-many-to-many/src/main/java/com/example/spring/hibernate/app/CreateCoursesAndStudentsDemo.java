package com.example.spring.hibernate.app;


import com.example.spring.hibernate.entity.Course;
import com.example.spring.hibernate.entity.Instructor;
import com.example.spring.hibernate.entity.InstructorDetail;
import com.example.spring.hibernate.entity.Review;
import com.example.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

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

            // create a course and save it to the session
            Course course = new Course("Pacman - How To Score One Million Points");
            session.save(course);

            // create and add students to the course
            Student tempStudent = new Student("John", "Doe", "john.doe@gmail.com");
            Student tempStudent2 = new Student("Mary", "Sue", "mary.sue@gmail.com");

            course.addStudent(tempStudent);
            course.addStudent(tempStudent2);

            // save the students
            System.out.println("\nSaving the students");
            session.save(tempStudent);
            session.save(tempStudent2);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Finished database transaction");

        }
    }
}
