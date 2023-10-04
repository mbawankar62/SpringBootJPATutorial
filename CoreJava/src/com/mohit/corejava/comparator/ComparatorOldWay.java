package com.mohit.corejava.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Comparator
//1st way
//https://www.javabrahman.com/java-8/the-complete-java-8-comparator-tutorial-with-examples/

class EmployeeComparator implements Comparator<Employee> 
{
	@Override
	public int compare(Employee emp1, Employee emp2)
	{
		return (emp1.getName().compareTo(emp2.getName()));
	}
}

class EmployeeComparatorByAge implements Comparator<Employee> 
{
	@Override
	public int compare(Employee emp1, Employee emp2)
	{
		return (emp1.getAge()- emp2.getAge());
	}
} 

public class ComparatorOldWay {

	static List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45),
														new Employee("Harry Major", 35),
														new Employee("Harry Major", 25), 
														new Employee("Ethan Hardy", 65),
														new Employee("Nancy Smith", 15),
														new Employee("Deborah Sprightly", 29)
														);

	public static void main(String args[])
	{
		Collections.sort(employeeList, new EmployeeComparator());
		employeeList.forEach(System.out::println);
		System.out.println("**********************************************************");
		Collections.sort(employeeList, new EmployeeComparatorByAge());
		employeeList.forEach(System.out::println);
		
		System.out.println("**********************************************************");
		//2nd way
		//with anonymous method name
		//no need of implementing comparator like above
		Collections.sort(employeeList, new Comparator<Employee>() {

			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (emp1.getAge()- emp2.getAge());
			}
			
		});
		employeeList.forEach((t)->System.out.println("output with nonymous method::"+t));
		employeeList.forEach(System.out::println);
		System.out.println("**********************************************************");
		
		//3rd way//java1.8 features its not about comparator
		Collections.sort(employeeList,(e1,e2)-> (e1.getAge() - e2.getAge()));
		employeeList.forEach(System.out::println);
	}
}
