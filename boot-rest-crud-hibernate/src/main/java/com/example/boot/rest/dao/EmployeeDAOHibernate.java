package com.example.boot.rest.dao;

import com.example.boot.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOHibernate implements EmployeeDAO {

    // define field for entityManager

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        // return results
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        // unwrap the session
        Session session = entityManager.unwrap(Session.class);

        // get and return the employee
        return session.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {

        // get the current session by unwraping the entity manager
        Session session = entityManager.unwrap(Session.class);

        // save employee
        session.saveOrUpdate(employee);

    }

    @Override
    public void deleteById(int id) {

        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // delete object with the primary key
        Query theQuery = session.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", id);

        theQuery.executeUpdate();
    }
}
