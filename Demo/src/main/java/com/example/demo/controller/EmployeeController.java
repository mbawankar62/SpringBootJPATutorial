package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/empController")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/findAllEmployee")
	public List<Employee> getAllEmployee(){
		return empService.findAllEmployee();
	}
	
	@GetMapping("/empById/{id}")
	public Employee findEmployeeById(@PathVariable("id") int empId) {
		
		Employee theEmployee = empService.findEmployeeById(empId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee Not Found:"+theEmployee);
		}
		return theEmployee; 
	}

	@PostMapping("/saveEmployee")
	public Employee addEmployee(@RequestBody Employee theEmp) {
		
		theEmp.setEmpID(0);
	    empService.saveEmployee(theEmp);
		return theEmp;
	}
	
	@PutMapping("/updateEmployee")
	public Employee UpdateEmployee(@RequestBody Employee theEmp) {
	    empService.saveEmployee(theEmp);
		return theEmp;
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String DeleteEmployee(@PathVariable int id) {
		
		Employee empId = empService.findEmployeeById(id);
		if(empId == null)
		{
			throw new RuntimeException("EmployeeNotFound");
		}
		
		empService.deleteEmployee(id);
		return "Deled Id is:"+id ;
		
	}
	
}

