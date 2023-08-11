package com.chloeliu.springboot.cruddemo.dao;

import com.chloeliu.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
