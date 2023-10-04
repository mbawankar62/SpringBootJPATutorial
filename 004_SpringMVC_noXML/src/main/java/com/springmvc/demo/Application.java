package com.springmvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//scan specific packages
//@SpringBootApplication(scanBasePackages = "com.example.myproject") 
//@SpringBootApplication(scanBasePackageClasses = CustomerController.class)
//@SpringBootApplication(exclude = DemoConfiguration.class) 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
