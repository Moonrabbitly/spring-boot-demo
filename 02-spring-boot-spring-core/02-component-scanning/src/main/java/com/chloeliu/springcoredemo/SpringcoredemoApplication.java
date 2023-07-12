package com.chloeliu.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*  Test scan a package outside of the main java application
@SpringBootApplication(
		scanBasePackages = {"com.chloeliu.springcoredemo",
		                    "com.chloeliu.util"}
)
*/

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
