package com.chloeliu.springboot.cruddemo.service;

//import com.chloeliu.springboot.cruddemo.dao.EmployeeDAO;
import com.chloeliu.springboot.cruddemo.dao.EmployeeRepository;
import com.chloeliu.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        //'Optional' type is often used to handle situations where the result might be absent
        //in this case, when there is no employee with the specified ID
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            //we didn't find the employee
            throw new RuntimeException("Did not find Employee id - " + theId);
        }
        return theEmployee;
    }

    //Apply @Transactional annotation at Service layer (when modifying database)
    //@Transactional  - when using JpaRepository, it includes @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
    //@Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
