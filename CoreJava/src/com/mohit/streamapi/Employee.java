package com.mohit.streamapi;

import java.util.List;

public class Employee implements Comparable<Employee>{
	
	private int id;
    private String name;
    private int salary;
    private int age;
    private String gender;
    private List<Employee> list;
   // private Date dateOfJoining;	

	@Override
	public int compareTo(Employee emp) {
		return this.salary - emp.salary;	
		//return this.age - emp.age;
		//return this.name.compareTo(emp.name);
		//return this.id - emp.id;
		//return this.dateOfJoining.compareTo(emp.dateOfJoining);
	}

	public Employee(int id, String name, int salary, int age ,String gender) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.gender = gender;
		//this.dateOfJoining = dateOfJoining;
	}

	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", gender=" + gender
				+ "]";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Employee> getList() {
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
}