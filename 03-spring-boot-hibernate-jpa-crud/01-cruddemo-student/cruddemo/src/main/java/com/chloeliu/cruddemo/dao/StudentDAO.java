package com.chloeliu.cruddemo.dao;


import com.chloeliu.cruddemo.entity.Student;

//DAO stands for "Data Access Object"
//method save/find is override in Class "StudentDAOImpl"
//save/find is a method in EntityManager
public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

}
