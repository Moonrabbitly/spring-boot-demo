package com.chloeliu.springboot.cruddemo.rest;

import com.chloeliu.springboot.cruddemo.dao.EmployeeDAO;
import com.chloeliu.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.chloeliu.springboot.cruddemo.entity.Employee;
import com.chloeliu.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //quick and dirty: inject employee dao (use constructor injection)
    public EmployeeRestController(EmployeeService employeeService)   {
        this.employeeService = employeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping(value = "/employee")
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}
    @GetMapping(value = "/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

}
