package com.example.boot.rest.service;

import com.example.boot.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
