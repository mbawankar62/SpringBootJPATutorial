package com.springboot.hibernate;

import java.util.List;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class Department {

	private int deptId;
	private String deptName;
	
	@OneToMany(fetch = FetchType.LAZY )
	@JoinColumn(name = "dept_id")
	private List<Employee> listOfEmployee;
	
	public Department() {
		super();
	}

	public Department(int deptId, String deptName, List<Employee> listOfEmployee) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.listOfEmployee = listOfEmployee;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}
}
