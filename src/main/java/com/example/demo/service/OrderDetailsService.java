package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.OrderException;
import com.example.demo.model.Item;
import com.example.demo.model.OrderDetails;

public interface OrderDetailsService {
	
	public OrderDetails addOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails updateOrder(OrderDetails order)throws OrderException;
	
	public OrderDetails removeOrder(Integer orderId)throws OrderException;
	
	public OrderDetails viewOrder(Integer orderId)throws OrderException;
	
	public List<Item> viewAllOrdersByCustomer(Integer customerId)throws OrderException,CustomerException;

}
