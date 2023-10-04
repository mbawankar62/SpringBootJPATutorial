package com.mohit.corejava.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComapringMehod {

	static List<Employee> employeeList = Arrays.asList(new Employee("Mohit", 18),
			new Employee("Anant", 30),
			new Employee("Anant", 28), 
			new Employee("Hitesh", 25),
			new Employee("Hitesh1", 26)
			);
	
	public static void main(String[] args) {
		
	     employeeList.stream().filter(e->e.getAge() >=25 && e.getAge()<=30).collect(Collectors.toList()).forEach(System.out::println);;
		//empAgeRange.forEach(s->System.out.println("Employe between 30 && 35::"+empAgeRange));
		 
		
		//Comparator<Employee> comparatorObj=Comparator.comparing(emp -> emp.getName());
		
		Comparator<Employee>  comparatorObj = Comparator.comparing(Employee::getName);
		Collections.sort(employeeList, comparatorObj);
		 employeeList.forEach(System.out::println);
		 
		 
		//sorted method
		 employeeList.stream().sorted((o1,o2) -> o1.getAge() - o2.getAge())
		 					//.forEach(t1->System.out.println("sorted salary:"+t1));
		 					.forEach(System.out::println);
		 
		
		 System.out.println("-----------------------------------------------");
		 //Comparator's thenComparing() method for multiple sort criteria 
		 System.out.println("-----------------------------------------------");
		//employeeList.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).forEach(System.out::println);
		 Comparator<Employee> empNameComparator = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge);
		 Collections.sort(employeeList, empNameComparator);
		  employeeList.forEach(System.out::println);
		 
		  System.out.println("-----------------------------------------------");
		  //Java 8 Comparator natural order sorting
			//List<String> empNames = employeeList.stream().map(Employee::getName).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		  	// empNames.forEach(System.out::println);
		  List<String> empNames = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
					  empNames.sort(Comparator.naturalOrder());
					  empNames.forEach(System.out::println);
		}
}

/*
Quick Explanation of the above code-
Comparator<Employee> comparatorObj=Comparator.comparing(emp -> emp.getName());
An instance of the Comparator, comparatorObj, is created using the static method Comparator.comparing().
The comparing() is passed a lambda expression, which corresponds to a Function<T,R> instance accepting 
an Employee object as input and returns an employee name – the sort key.
Using comparatorObj for sorting results in a correctly sorted Employee list by name.
NOTE – Instead of the lambda expression, you can also use an equivalent method reference as well. 
The comparing() method with a method reference will then be written like this –
Comparator comparatorObj = Comparator.comparing(Employee::getName);
*/

