package com.example.demo.service;

import com.example.demo.exceptions.CustomerException;
import com.example.demo.model.Customer;

public interface CustomerService {
	
public Customer addCustomer(Customer customer)throws CustomerException;
	
	public Customer updateCustomer(Customer customer)throws CustomerException;
	
	public Customer removeCustomerById(Integer customerId)throws CustomerException;
	
	public Customer viewCustomer(Integer customerId)throws CustomerException;

}
