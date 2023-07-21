package com.chloeliu.cruddemo.dao;


import com.chloeliu.cruddemo.entity.Student;
import java.util.List;

//DAO stands for "Data Access Object"
//method save/find is override in Class "StudentDAOImpl"
//save/find is a method in EntityManager
public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastname(String theLastname);

    void update(Student theStudent);

    void delete(int id);

    int deleteAll(); //return how many row it deletes
}
