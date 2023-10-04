package com.mohit.springmvc.crm.dao;

import java.util.List;

import com.mohit.springmvc.crm.entity.Customer;

public interface CustomerDAO {

	//public List<Customer> getCustomers();
	
	public List<Customer> getCustomers(int theSortField);

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public List<Customer> searchCustomers(String theSearchName);
	
}
