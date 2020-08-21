package com.example.boot.rest.dao;

import com.example.boot.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJPA implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        Query query = entityManager.createQuery("from Employee");

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return results
        return employees;
    }

    @Override
    public Employee findById(int id) {

        // get employee
        Employee employee = entityManager.find(Employee.class, id);

        // return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {

        // save or update the employee
        Employee theEmployee = entityManager.merge(employee);

        // update with id from db ... so we can get generated id for save/insert
        employee.setId(theEmployee.getId());
    }

    @Override
    public void deleteById(int id) {

        // delete object with primary key
        Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);

        theQuery.executeUpdate();
    }
}
