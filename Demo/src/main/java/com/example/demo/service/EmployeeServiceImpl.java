package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	
	
	public EmployeeServiceImpl(EmployeeRepository emprepo) {
		this.emprepo = emprepo;
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		//List<Employee> theEmp=emprepo.findAll();
		return emprepo.findAll();
	}

	@Override
	public void saveEmployee(Employee emp) {
		emprepo.save(emp);
	}

	
	@Override
	public void deleteEmployee(int empId) {
      emprepo.deleteById(empId);
	}

	@Override
	public Employee findEmployeeById(int empId) {
		
		  Optional<Employee> result = emprepo.findById(empId);
		  
		  Employee theEmp = null;
		  if(result.isPresent()) {
			  theEmp = result.get();
		  }
		  
		  else {
			  throw new RuntimeException("Given Id is Not Found:"+result);
		  }
		  
		  return theEmp;
	}

}
