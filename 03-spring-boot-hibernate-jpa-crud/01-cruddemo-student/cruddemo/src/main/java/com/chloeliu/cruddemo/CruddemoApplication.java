package com.chloeliu.cruddemo;

import com.chloeliu.cruddemo.dao.StudentDAO;
import com.chloeliu.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//CommandLineRunner to run command after bean is created
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "pauldoe@luv2code.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display student object
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
		
	}
}








