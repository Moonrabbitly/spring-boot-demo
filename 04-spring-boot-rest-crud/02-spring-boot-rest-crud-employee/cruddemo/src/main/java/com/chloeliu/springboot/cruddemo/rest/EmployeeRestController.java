package com.chloeliu.springboot.cruddemo.rest;

import com.chloeliu.springboot.cruddemo.dao.EmployeeDAO;
import com.chloeliu.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.chloeliu.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    //quick and dirty: inject employee dao (use constructor injection)
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    //expose "/employees" and return a list of employees
    @GetMapping(value = "/employee")
    public List<Employee> getEmployee() {
        return employeeDAO.findAll();
    }

}
