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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {

    // define fields
    // lombok for getters/setters

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Setter
    @Column(name = "comment")
    private String comment;

    // define constructors
    public Review() {
    }

    public Review(String comment) {
        this.comment = comment;
    }

    public Review(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    // generate toString

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
