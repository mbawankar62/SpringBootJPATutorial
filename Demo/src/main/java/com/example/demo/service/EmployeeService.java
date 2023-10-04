package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAllEmployee();
	public void saveEmployee(Employee emp);
	public void  deleteEmployee(int empId);
	public Employee findEmployeeById(int theId);
}


