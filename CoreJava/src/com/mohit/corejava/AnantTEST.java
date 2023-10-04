package com.mohit.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

 class EmployeeAnant implements Comparable<EmployeeAnant>{
	
	private int id;
    private String name;
    private int salary;
    

	@Override
	public int compareTo(EmployeeAnant emp) {
		return emp.salary - this.salary;
	}

	public EmployeeAnant(int id, String name, int salary ) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	
	
}

public class AnantTEST {
	
	
	public static void main(String[] args) {
	
		EmployeeAnant e1 = new EmployeeAnant(1,"mohit", 505);
		EmployeeAnant e2 = new EmployeeAnant(2,"anant", 500000);
		EmployeeAnant e3 = new EmployeeAnant(3,"sakshi", 5000);
		
		List <EmployeeAnant>list = new ArrayList<>();
		
		list.add(e2);
		list.add(e1);
		list.add(e3);
		Collections.sort(list);
		System.out.println(list);
		
		List<EmployeeAnant> list1 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(list1);
		
		//List <EmployeeAnant> list2 = list.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());
		List <EmployeeAnant> list3 = list.stream().sorted((a,b)-> b.compareTo(a)).collect(Collectors.toList());
	   System.out.println(list3);
	}
	

}
