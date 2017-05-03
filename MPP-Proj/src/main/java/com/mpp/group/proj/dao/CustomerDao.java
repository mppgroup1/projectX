package com.mpp.group.proj.dao;

import java.util.List;

import com.mpp.group.proj.model.Customer;

public interface CustomerDao {

	public List<Customer> listAllCustomer();
	public void addCustomer(Customer customers);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int id);
	public Customer findCustomerById(int id);
	
}
