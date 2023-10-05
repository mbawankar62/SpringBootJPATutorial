package com.mohit.springboot.cruddemo.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.mohit.springboot.cruddemo.dao.EmployeeRepository;
import com.mohit.springboot.cruddemo.entity.Employee;

import org.springframework.data.domain.Sort;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}
	
	//if you didn't provide all payload then it will be null
	@Override
	 public Employee updateEmployee(int id, Employee theEmployee) {
	        // get the Employee from DB by id update with new value getting from request
		 Employee employee = employeeRepository.findById(id).get(); // DB
		 		  //employee.setId(theEmployee.getId());
		 		  employee.setFirstName(theEmployee.getFirstName());
			      employee.setLastName(theEmployee.getLastName());
			      employee.setEmail(employee.getEmail());
	     return employeeRepository.save(employee);
	  }
	
	@Override
	public Employee updateEmployeeByFields(int id, Map<String, Object> fields) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Employee.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingEmployee.get(), value);
            });
            return employeeRepository.save(existingEmployee.get());
        }
        return null;
    }
	 /*
	@Override
    public Employee updateEmployee(int id) {

		//Employee empWithId = employeeRepository.findById(id)
				//.orElseThrow(() -> new RuntimeException("Emp with given id :" +id));

		//Employee updatedEmployee = employeeRepository.save(empWithId);

       // return mapToEmployee(updatedEmployee);
		return employeeRepository.findById(id)
			      .map(employee -> {
			        employee.setName(newEmployee.getName());
			        employee.setRole(newEmployee.getRole());
			        return repository.save(employee);
			      })
			      .orElseGet(() -> {
			        newEmployee.setId(id);
			        return repository.save(newEmployee);
			      });
    }

	private Employee mapToEmployee(Employee theEmployee){
		Employee employee = new Employee();
		employee.setId(theEmployee.getId());
		employee.setFirstName(theEmployee.getFirstName());
		employee.setLastName(theEmployee.getLastName());
		employee.setEmail(employee.getEmail());
        return employee;
    }*/
	
//  @PostConstruct
//  public void initDB() {
//      List<Product> products = IntStream.rangeClosed(1, 200)
//              .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//              .collect(Collectors.toList());
//      repository.saveAll(products);
//  }
	
		public List<Employee> findEmployeeWithSorting(String field) {
			return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
		}

		//offset means page start from 0, 0 th page we will see 10 record(page size)
		public Page<Employee> findEmployeeWithPagination(int offset, int pageSize) {
			Page<Employee> products = employeeRepository.findAll(PageRequest.of(offset, pageSize));
			return products;
		}

	    public  Page<Employee>  findEmployeeWithPaginationAndSorting(int offset,int pageSize,String field){
	    	//Page<Employee> products = employeeRepository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
	    	Page<Employee> products = employeeRepository.findAll(PageRequest.of(offset, pageSize,Sort.by(Sort.Direction.ASC,field)));
	        return  products;
	    }

		
		public List<Employee> findByEmplyeeFirstNameAndEmployeeEmail() {
			//List<Employee> findByEmplyeeFirstNameAndEmployeeEmail = employeeRepository.findEmplyeeByFirstNameAndEmail();
			//return findByEmplyeeFirstNameAndEmployeeEmail;
			return null;
		}
		
	  // public Employee findByEmail(String email) {	     
		//       Employee result = employeeRepository.findByEmail(email);	     
		//       return result; 
		//    }
	   
	   //sharad 201 demo 
	   @Override
	   public Employee saveEmployee(Employee theEmployee) {
			return employeeRepository.save(theEmployee);
		}
		
		
}






