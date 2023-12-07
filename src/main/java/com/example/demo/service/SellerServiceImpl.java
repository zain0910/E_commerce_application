package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.SellerException;
import com.example.demo.model.Seller;
import com.example.demo.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerRepository restaurantRepository;

	
	
	
	@Override
	public Seller addSeller(Seller restaurant) throws SellerException {
		Optional<Seller> optionalSeller = restaurantRepository.findById(restaurant.getSellerId());
		if(optionalSeller.isPresent()) {
			throw new SellerException("Seller already exists..");
		}else {
			return restaurantRepository.save(restaurant);
		}
	}




	@Override
	public Seller updateSeller(Seller restaurant) throws SellerException {
		Optional<Seller> optionalSeller = restaurantRepository.findById(restaurant.getSellerId());
		if(optionalSeller.isPresent()) {
			return restaurantRepository.save(restaurant);
		}else {
			throw new SellerException("No such Seller exists..");
		}
	}




	@Override
	public Seller removeSeller(Integer restaurantId) throws SellerException {
		Optional<Seller> optionalSeller = restaurantRepository.findById(restaurantId);
		if(optionalSeller.isPresent()) {
			Seller restaurant = optionalSeller.get();
			restaurantRepository.delete(restaurant);
			return restaurant;
		}else {
			throw new SellerException("No Seller found with ID: "+restaurantId);
		}
	}




	@Override
	public Seller viewSeller(Integer restaurantId) throws SellerException {
		Optional<Seller> optionalSeller = restaurantRepository.findById(restaurantId);
		if(optionalSeller.isPresent()) {
			Seller restaurant = optionalSeller.get();
			return restaurant;
		}else {
			throw new SellerException("No Seller found with ID: "+restaurantId);
		}
	}

}
