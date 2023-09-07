package com.chloeliu.springboot.cruddemo.dao;

import com.chloeliu.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it...no need to write any code LOL!
    //that's the beauty of spring data JPA

    //Spring Data JPA Magic!!
    //We get these methods for free:
    //findAll()
    //findById(...)
    //save(...)
    //deleteById(...)

}
