package com.chloeliu.springboot.cruddemo.dao;

import com.chloeliu.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;
    }

    //Note here we don't handle @Transactional at DAO layer, it will be handled in the Service layer
    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        //if id == 0, it will insert/save, else, it will update the current employee
        Employee dbEmployee = entityManager.merge(theEmployee);

        //return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //remove employee
        entityManager.remove(theEmployee);
    }

}
