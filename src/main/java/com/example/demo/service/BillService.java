package com.example.demo.service;

import com.example.demo.exceptions.BillException;
import com.example.demo.exceptions.CustomerException;
import com.example.demo.exceptions.ItemException;
import com.example.demo.model.Bill;

public interface BillService {
	
	public Bill addBill(Bill bill) throws BillException;
	
	public Bill updateBill(Bill bill)throws BillException;
	
	public Bill removeBill(Integer billId)throws BillException;
	
	public Bill viewBill(Integer billId)throws BillException;
	
	public String generateTotalBillById(Integer customerId)throws ItemException,CustomerException;
	

}
