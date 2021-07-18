package com.nagarro.telecompractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeRestApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApi1Application.class, args);
	}

}
