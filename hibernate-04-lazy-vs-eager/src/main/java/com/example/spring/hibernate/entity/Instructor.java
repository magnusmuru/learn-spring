package com.example.spring.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    // annotate the class as an entity and map to the db table
    // define the fields
    // Lombok for getters/setters
    // annotate the fields with db column names
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    // set up mapping to InstructorDetail
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "instructor",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Course> courses;


    // create constructors
    public Instructor() {

    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // generate a toString()
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }

    public void add(Course tempCourse) {
        if (courses == null) {
            courses = new ArrayList<>();
        }

        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }
}
