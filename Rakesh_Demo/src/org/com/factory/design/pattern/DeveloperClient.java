package org.com.factory.design.pattern;

public class DeveloperClient {

	public static void main(String[] args) {

		//Employee emp = new WebDeveloper();//problem is tightly couple created by client manually which type of getting created, based on input want to create obj  by using design factory
	
		Employee employee = EmployeeFactoryDesign.getEmployee("ANDOROID DEVELOPER");
		int salary = employee.salary();
		System.out.println(salary);
		
		Employee employee2 = EmployeeFactoryDesign.getEmployee("WEB DEVELOPER");
		int salary2 = employee2.salary();
		System.out.println(salary2);
	}

}
