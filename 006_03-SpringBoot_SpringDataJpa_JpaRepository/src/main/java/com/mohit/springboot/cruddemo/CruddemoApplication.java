package com.mohit.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mohit.springboot.cruddemo.dao.EmployeeRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
//https://springdoc.org/#plugins
@OpenAPIDefinition(info = @Info(title="Employee Managment" , version="v1" ,description = "Employee CRUD Operation" ,
				   contact = @Contact(email = "mbawankar@gmail.com")))
public class CruddemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
}
