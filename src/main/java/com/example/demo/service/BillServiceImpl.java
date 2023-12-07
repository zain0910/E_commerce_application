package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BillException;
import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.ItemException;
import com.example.demo.model.Bill;
import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class BillServiceImpl implements BillService{
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	CustomerRepository customerRepository;

	
	
	@Override
	public Bill addBill(Bill bill) throws BillException {
		Optional<Bill> optionalBill = billRepository.findById(bill.getBillId());
		if(optionalBill.isPresent()) {
			throw new BillException("Bill already exists..");
		}else {
			return billRepository.save(bill);
		}
	}


	@Override
	public Bill updateBill(Bill bill) throws BillException {
		Optional<Bill> optionalBill = billRepository.findById(bill.getBillId());
		if(optionalBill.isPresent()) {
			return billRepository.save(bill);
		}else {
			throw new BillException("Bill doesn't exists..");
		}
	}


	@Override
	public Bill removeBill(Integer billId) throws BillException {
		Optional<Bill> optionalBill = billRepository.findById(billId);
		if(optionalBill.isPresent()) {
			Bill bill = optionalBill.get();
			billRepository.delete(bill);
			return bill;
		}else {
			throw new BillException("Bill not found with ID: "+billId);
		}
		
	}


	@Override
	public Bill viewBill(Integer billId) throws BillException {
		Optional<Bill> optionalBill = billRepository.findById(billId);
		if(optionalBill.isPresent()) {
			return optionalBill.get();
		}else{
			throw new BillException("Bill not found with ID: "+billId);
		}
	}


	@Override
	public String generateTotalBillById(Integer customerId) throws ItemException, CustomerException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			List<Item> items = customer.getCart().getItemList();
			
			if(items.size() > 0) {
				
				Double total = 0.0;
				for(Item item : items) {
					total += (item.getCost()*item.getQuantity()); 
				}
				
				return "The total bill for "+customer.getFullName()+" is "+total;
				
			}else {
				throw new ItemException("No order items found for "+customer.getFullName());
			}
			
		}else {
			throw new CustomerException("No Customer found with ID: "+customerId);
		}
	}

	
	
	
	
}

