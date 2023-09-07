package com.chloeliu.springboot.cruddemo.rest;

//import com.chloeliu.springboot.cruddemo.dao.EmployeeDAO;
//import com.chloeliu.springboot.cruddemo.dao.EmployeeDAOJpaImpl;
import com.chloeliu.springboot.cruddemo.entity.Employee;
import com.chloeliu.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //add mapping for POST /employee - add new employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        //also just in case they pass an id in JSON...set id to 0
        //this is to force a save of new item...instead of update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for PUT /employee - update existing employee
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    //add mapping for DELETE /employee/{employeeId} - delete employee
    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }

}









