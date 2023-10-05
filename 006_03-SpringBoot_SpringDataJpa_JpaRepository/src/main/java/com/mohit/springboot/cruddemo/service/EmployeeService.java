package com.mohit.springboot.cruddemo.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.mohit.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
	//public Employee updateEmployee(int id);
	
	public Employee updateEmployee(int id, Employee theEmployee);
	
	public Employee updateEmployeeByFields(int id, Map<String, Object> fields);
	
	public List<Employee> findEmployeeWithSorting(String field);
	
	public Page<Employee> findEmployeeWithPagination(int offset, int pageSize);
	
	public Page<Employee> findEmployeeWithPaginationAndSorting(int offset,int pageSize,String field);
	
	public List<Employee> findByEmplyeeFirstNameAndEmployeeEmail();
	
	//public Employee findByEmail(String email);
	
	public Employee saveEmployee(Employee theEmployee);
	
}
