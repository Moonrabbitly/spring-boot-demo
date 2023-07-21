package com.chloeliu.cruddemo.dao;

import com.chloeliu.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //implement findById method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        //VERY IMPORTANT - "FROM Student" - 'Student' here is the name of JPA Entity (class name)
        //this is not the name of the database table
        //all JPQL syntax us based on entity name and entity fields

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);

        //return query results
        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastname(String theLastname) {
        //create query
        //JPQL Named Parameters are prefixed with a colon :
        //":theData" - think of this is a placeholder that is filled in later
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE lastName=:theData", Student.class);

        //set query parameters
        theQuery.setParameter("theData", theLastname);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    //Notice that @Transactional annotation required when database needs to be changed like save/update/delete
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        //retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        //if we don't have executeUpdate() in the end, it only can be TypedQuery<Student>

        return numRowsDeleted;
    }
}


