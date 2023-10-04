package com.mohit.corejava.comparator;

import java.util.Objects;

public class Emp2 {

	private int regno;
	private String name;

	// constructor of Employee class
	public Emp2(int regno, String name) {
		this.name = name;
		this.regno = regno;
	}

	public int getRegno() {
		return regno;
	}

	public void setRegno(int Regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override  
	public boolean equals(Object obj)   
	{  
		if (obj == null)   
			return false;  
		if (obj == this)  
			return true;  
		return this.getRegno() ==  ((Emp2) obj). getRegno() && this.getName() == ((Emp2) obj).getName();  
	}  
	
	@Override
	public int hashCode() {
		return Objects.hash(regno,name);
	}
}
