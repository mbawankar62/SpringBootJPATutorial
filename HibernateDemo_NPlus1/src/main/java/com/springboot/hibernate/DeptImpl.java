package com.springboot.hibernate;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public class DeptImpl {

	@Autowired
	public DepartmentRepository repo;
	
	public List<Department> findAll() {
		
		List<Department> dept = repo.findAll();
		return dept;
		
		
	}

}
