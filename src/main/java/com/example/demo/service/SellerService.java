package com.example.demo.service;

import com.example.demo.exceptions.SellerException;
import com.example.demo.model.Seller;

public interface SellerService {
	
	public Seller addSeller(Seller restaurant)throws SellerException;
	
	public Seller updateSeller(Seller restaurant)throws SellerException;
	
	public Seller removeSeller(Integer restaurantId)throws SellerException;
	
	public Seller viewSeller(Integer restaurantId)throws SellerException;
	
	

}
