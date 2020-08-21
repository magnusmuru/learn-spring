package com.example.boot.rest.dao;

import com.example.boot.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
