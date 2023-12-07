package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.OrderException;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.OrderDetails;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	
	
	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> optionalOrderDetails = orderDetailsRepository.findById(order.getOrderId());
		if(optionalOrderDetails.isPresent()) {
			throw new OrderException("Order already exists..");
		}else {
			return orderDetailsRepository.save(order);
		}
	}



	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> optionalOrderDetails = orderDetailsRepository.findById(order.getOrderId());
		if(optionalOrderDetails.isPresent()) {
			return orderDetailsRepository.save(order);
		}else {
			throw new OrderException("Order such Order exists..");
		}
	}



	@Override
	public OrderDetails removeOrder(Integer orderId) throws OrderException {
		Optional<OrderDetails> optionalOrderDetails = orderDetailsRepository.findById(orderId);
		if(optionalOrderDetails.isPresent()) {
			OrderDetails order = optionalOrderDetails.get();
			orderDetailsRepository.delete(order);
			return order;
		}else {
			throw new OrderException("No Order found with ID: "+orderId);
		}
	}



	@Override
	public OrderDetails viewOrder(Integer orderId) throws OrderException {
		Optional<OrderDetails> optionalOrderDetails = orderDetailsRepository.findById(orderId);
		if(optionalOrderDetails.isPresent()) {
			OrderDetails order = optionalOrderDetails.get();
			return order;
		}else {
			throw new OrderException("No Order found with ID: "+orderId);
		}
	}



	@Override
	public List<Item> viewAllOrdersByCustomer(Integer customerId) throws OrderException, CustomerException {
		Optional<Customer> optionalCustomer =customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			 List<Item> itemList = customer.getCart().getItemList();
			 if(itemList.size() > 0) {
				 return itemList;
			 }else {
				 throw new OrderException("No Orders found..");
			 }
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

}

