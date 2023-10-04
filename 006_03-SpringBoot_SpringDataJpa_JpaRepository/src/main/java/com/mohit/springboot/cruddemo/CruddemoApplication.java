package com.mohit.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mohit.springboot.cruddemo.dao.EmployeeRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CruddemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
}
