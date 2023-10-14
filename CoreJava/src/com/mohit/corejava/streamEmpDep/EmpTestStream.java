package com.mohit.corejava.streamEmpDep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmpTestStream {

	public static void main(String[] args) {


		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		//Query 3.1 : How many male and female employees are there in the organization?
		Map<String,Long>noOfMaleAndFemaleEmployees= employeeList.stream().
											collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println("noOfMaleAndFemaleEmployees:"+noOfMaleAndFemaleEmployees);
		
		//Query 3.2 : Print the name of all departments in the organization?
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
		//Techm interview questions
		//find the department and its employee
		Map<String,Long> emplist = employeeList.stream().collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.counting()));
		System.out.println("EmpList::"+emplist);
		
		//Query 3.3 : What is the average age of male and female employees?
		Map<String, Double> avgAgeOfMaleAndFemaleEmployees=
				employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgAgeOfMaleAndFemaleEmployees);
        
		//Query 3.4 : Get the details of highest paid employee in the organization?
		Optional<Employee> highestPaidEmployeeWrapper=
				employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
				         
		Employee highestPaidEmployee = highestPaidEmployeeWrapper.get();
		//employeeList.stream().max(Collectors.groupingBy(Employee::getSalary)).
		System.out.println("Details Of Highest Paid Employee : ");
        
		System.out.println("==================================");
		         
		System.out.println("ID : "+highestPaidEmployee.getId());
		         
		System.out.println("Name : "+highestPaidEmployee.getName());
		         
		System.out.println("Age : "+highestPaidEmployee.getAge());
		         
		System.out.println("Gender : "+highestPaidEmployee.getGender());
		         
		System.out.println("Department : "+highestPaidEmployee.getDepartment());
		         
		System.out.println("Year Of Joining : "+highestPaidEmployee.getYearOfJoining());
		         
		System.out.println("Salary : "+highestPaidEmployee.getSalary());
		
		//Query 3.8 : Get the details of youngest male employee in the product development department?
		Optional<Employee> youngestMaleEmployeeInProductDevelopmentWrapper=
				employeeList.stream()
				            .filter(e -> e.getGender()=="Male" && e.getDepartment()=="Product Development")
				            .min(Comparator.comparingInt(Employee::getAge));
		System.out.println("youngestMaleEmployeeInProductDevelopmentWrapper : "+youngestMaleEmployeeInProductDevelopmentWrapper);
		
	    //Employee with highest salary from each department
		Map<String, List<Employee>> empWithDep = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("empWithDep::"+empWithDep);
		System.out.println("---------------------------------------------");
		
		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment))
							 .forEach((k,v)->System.out.println("Department:"+k+"\t Employees::"+v));
		
		
				
		Optional<Employee> maxSalaryEmp = employeeList.stream()
						 							.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
				 
		System.out.println("Employee with max salary:" 
				            + (maxSalaryEmp.isPresent()? maxSalaryEmp.get():"Not Applicable"));
				
	  //Find max salary of emp from each department
		
	  employeeList.stream().collect(Collectors.groupingBy(e ->e.getDepartment(),
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),Optional::get )))
				.forEach((k,v)->System.out.println("Department::"+k+"---Employee Name:: "+v.getName()+","+v.getSalary()));
		
	}

}
