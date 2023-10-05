package com.mohit.springboot.cruddemo.rest;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.MediaType;
import com.mohit.springboot.cruddemo.entity.Employee;
import com.mohit.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.mohit.springboot.cruddemo.pagingandsorting.APIResponseWithPagingAndSorting;
import com.mohit.springboot.cruddemo.service.EmployeeService;

//http://localhost:8055/employee-jpaRepository/empController/employees
//@Controller
@RestController
@RequestMapping("/empController")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//log will generate on console
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	//@ResponseBody
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		LOGGER.info("Finding Employee by ID:"+employeeId);
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@Valid @RequestBody Employee theEmployee) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	//25 Aug 2023 Sharad
	//here we will get 201 status code
	@PostMapping("/addEmployees")
	public ResponseEntity<Employee> addEmployee_1(@Valid @RequestBody Employee theEmployee) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theEmployee.setId(0);
		
		Employee emp =employeeService.saveEmployee(theEmployee);
		
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PatchMapping("/employees")
	public Employee updateEmployee2(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//Here we need to give all Payload else not provided feild will give null response
	@PutMapping("/employees/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int employeeId ) {
		
		Employee theEmployee=employeeService.updateEmployee(employeeId, employee);
		return theEmployee;
	}
	
	//even if we give @PatchMapping it will be same as put so need to give other implementation
	@PatchMapping("/employees/{employeeId}")
	public Employee updateEmployee_1(@RequestBody Employee employee,@PathVariable int employeeId ) {
		
		Employee theEmployee=employeeService.updateEmployee(employeeId, employee);
		return theEmployee;
	}
	
	@PutMapping("/updateEmployeeFields/{id}")
    public Employee updateEmployeeFields(@PathVariable int id,@RequestBody Map<String, Object> fields){
        return employeeService.updateEmployeeByFields(id,fields);
    }
	
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
	/***********Exception Handling ********************/
	
	//@GetMapping("/employees/{employeeId}")
	public Employee getEmployee1(@PathVariable int employeeId) {
		
		LOGGER.info("Finding Employee by ID:"+employeeId);
		Employee theEmployee = employeeService.findById(employeeId);
		
		if ( (employeeId != theEmployee.getId() || (employeeId < 0) )) {			
			throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
		
	}

	/*
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {
		
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
		
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}	*/
	
	//Paging and Sorting
	//https://github.com/Java-Techie-jt/spring-boot-pagination-sorting/blob/main/src/main/java/com/javatechie/jpa/PaginationSortingExampleApplication.java
	 @GetMapping
	private APIResponseWithPagingAndSorting<List<Employee>> getEmployee() {
			List<Employee> allEmployees = employeeService.findAll();
			return new APIResponseWithPagingAndSorting<>(allEmployees.size(), allEmployees);
		}
	 
	 //base of feild which we are passing
	 @GetMapping("/{field}")
	    private APIResponseWithPagingAndSorting<List<Employee>> getProductsWithSort(@PathVariable String field) {
	        List<Employee> allEmployees = employeeService.findEmployeeWithSorting(field);
	        return new APIResponseWithPagingAndSorting<>(allEmployees.size(), allEmployees);
	    }
	 
	 @GetMapping("/pagination/{offset}/{pageSize}")
	    private APIResponseWithPagingAndSorting<Page<Employee>> getEmployeeWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	        Page<Employee> productsWithPagination = employeeService.findEmployeeWithPagination(offset, pageSize);
	        return new APIResponseWithPagingAndSorting<>(productsWithPagination.getSize(), productsWithPagination);
	    }
	 
	 @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	    private APIResponseWithPagingAndSorting<Page<Employee>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
	        Page<Employee> productsWithPagination = employeeService.findEmployeeWithPaginationAndSorting(offset, pageSize, field);
	        return new APIResponseWithPagingAndSorting<>(productsWithPagination.getSize(), productsWithPagination);
	    }
	 
	 	@GetMapping("/findByEmplyeeFirstNameAndEmployeeEmail")
		//@ResponseBody
		public List<Employee> findByEmplyeeFirstNameAndEmployeeEmail() {
			return employeeService.findByEmplyeeFirstNameAndEmployeeEmail();
		}
	 	
	 	//
	    //public Employee testFindByEmail(String email) {	     
	       
	     //  Employee result = employeeService.findByEmail(email);	     
	    //   return result;	     
	    //}
}






