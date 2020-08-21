package com.example.spring.mvchibernate.dao;


import com.example.spring.mvchibernate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Long> {

}
