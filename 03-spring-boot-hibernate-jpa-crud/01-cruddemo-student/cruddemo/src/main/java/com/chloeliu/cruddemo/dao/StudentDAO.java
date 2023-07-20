package com.chloeliu.cruddemo.dao;


import com.chloeliu.cruddemo.entity.Student;

//DAO stands for "Data Access Object"
//method save is override in Class "StudentDAOImpl"
//save is a method in EntityManager
public interface StudentDAO {
    void save(Student theStudent);
}
