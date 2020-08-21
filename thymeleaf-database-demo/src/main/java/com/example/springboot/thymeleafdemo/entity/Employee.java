package com.example.springboot.thymeleafdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@Getter
	@Setter
	private int id;
	
	@Column(name="first_name")
	@Getter
	@Setter
	private String firstName;
	
	@Column(name="last_name")
	@Getter
	@Setter
	private String lastName;
	
	@Column(name="email")
	@Getter
	@Setter
	private String email;
	
		
	// define constructor

	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
		
}











