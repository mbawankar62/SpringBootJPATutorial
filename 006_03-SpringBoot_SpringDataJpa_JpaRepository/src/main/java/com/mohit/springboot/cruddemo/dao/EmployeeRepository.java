package com.mohit.springboot.cruddemo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mohit.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
	//3rd way
	//https://www.bezkoder.com/jpa-native-query/
	
	//@Query("SELECT firstName , email FROM Employee ORDER BY firstName ,email")
	//@Query(" FROM Employee e where e.empname = firstName ")
	//public List<Employee> findEmplyeeByFirstNameAndEmail(String firstName);
	//public List<Employee> findEmplyeeByFirstNameAndEmail(@Param("firstName") String Name); //empname = firstName != Name
	
	//public Employee findByEmail(String email);
	
}
