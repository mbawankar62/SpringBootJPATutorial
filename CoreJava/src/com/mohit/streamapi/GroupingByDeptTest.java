package com.mohit.streamapi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class EmployeeClass {

	private int id;
	private String name;
	private int deptCode;
	private String code;
	private Department department;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department dep) {
		this.department = dep;
	}
	public EmployeeClass(int id, String name, int deptCode, String code, Department dep) {
		super();
		this.id = id;
		this.name = name;
		this.deptCode = deptCode;
		this.code = code;
		this.department = dep;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptCode=" + deptCode + ", code=" + code + ", dep=" + department
				+ "]";
	}
	 
	
}

class Department{
	
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	String deptName;

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + "]";
	}
}

public class GroupingByDeptTest {

	public static void main(String args[]) {
		
		List<EmployeeClass> empList = new ArrayList<>();
		empList.add(new EmployeeClass(1,"A",10,"AA", new Department("hr")));
		empList.add(new EmployeeClass(2,"B",100,"BB", new Department("finance")));
		empList.add(new EmployeeClass(3,"C",7654,"CC", new Department("payroll")));
		empList.add(new EmployeeClass(4,"D",6543,"DD", new Department("admin")));
		empList.add(new EmployeeClass(5,"E",2099,"EE", new Department("hr")));
		empList.add(new EmployeeClass(6,"F",5000,"FF",  new Department("finance")));
		empList.add(new EmployeeClass(7,"G",65411,"GG",  new Department("finance")));
								
		
		Map<String, Long> collect = empList.stream().collect(Collectors.groupingBy(emp->emp.getDepartment().getDeptName(),Collectors.counting()));
		
		System.out.println(collect);
		
		//Query 3.2 : Print the name of all departments in the organization?
		empList.stream().map(emp->emp.getDepartment().getDeptName()).distinct().forEach(System.out::println);
		
	}
}
