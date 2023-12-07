package com.example.demo.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CustomerException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isPresent()) {
			throw new CustomerException("Customer already exists..");
		}else {
			return customerRepository.save(customer);
		}
	}


	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isPresent()) {
			return customerRepository.save(customer);
		}else {
			throw new CustomerException("No such customer exists..");
		}
	}


	@Override
	public Customer removeCustomerById(Integer customerId) throws CustomerException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			customerRepository.delete(customer);
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}


	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

}
