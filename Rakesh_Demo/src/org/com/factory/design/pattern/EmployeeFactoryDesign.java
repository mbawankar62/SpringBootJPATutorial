package org.com.factory.design.pattern;

// factory class have the method which will return obj of particular class based on clients input 
public class EmployeeFactoryDesign {


	//get the employee
	public static Employee getEmployee(String empType) {
		
		if(empType.trim().equalsIgnoreCase("ANDOROID DEVELOPER")) {
		return new AndroidDeveloper();
		}
		else if(empType.trim().equalsIgnoreCase("WEB DEVELOPER")) {
			return new WebDeveloper();
		}
		else {
			return null;
		}
			
	}
}
