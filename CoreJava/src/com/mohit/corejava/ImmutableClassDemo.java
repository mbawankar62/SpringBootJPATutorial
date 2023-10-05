package com.mohit.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class Employee {
	
	private final String name;
	private final int id;
	private final Address address;
	private  List<String> hobbies;

	public Employee(String name, int id, Address address) throws CloneNotSupportedException {
	//public Employee(String name, int id, Address address) {
		super();
		this.name = name;
		this.id = id;
		this.address = (Address) address.clone();
		//this.address = address;
	}
/*
	public Employee(String name, int id, Address address, ArrayList<String> hobbies) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.hobbies = hobbies;
	}*/
	
	public Employee(String name, int id, Address address, List<String> hobbies) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.hobbies = new ArrayList<>();
		{
			for(String hobby : hobbies) {
				hobbies.add(hobby);
			}
		}
	}
	
	public List<String> getHobbies(){
		
		List<String> list  = new ArrayList<>();
		{
			for(String hobby : list) {
				hobbies.add(hobby);
			}
		}
		return list;
	}
	
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", address=" + address + ", hobbies=" + hobbies + "]";
	}

	/*@Override
	public String toString() {
		return "Employee  [name=" + name + ", id=" + id + ", address=" + address + "]";
	}*/

	
}

class Address {
    private int id;
    private String address;


    public Address(int id, String address) {
        super();
        this.id = id;
        this.address = address;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", address=" + address + "]";
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class ImmutableClassDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
        
       // Employee employee = new Employee("ramesh", 200, new Address(100, "pune"));
        //Address address = new Address(100, "pune");
       // Address address = employee.getAddress();
        //System.out.println("1 - address"+address+"Employee::"+employee);
        // Before changes to object
       // System.out.println(" Before changes to object :: " + employee.toString());

        // Change the address object
        //address.setAddress("mumbai");

       // System.out.println(" After changes to object :: " + employee.toString());
        
        
        Employee employee2 = new Employee("ramesh", 200, new Address(100, "pune"),new ArrayList<>(Arrays.asList("Cricket","Tennis")));
        System.out.println(" After changes to object :: " + employee2.toString());
        
        
    }
}
