package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authservice.UserSessionService;
import com.example.demo.exceptions.SellerException;
import com.example.demo.model.Seller;
import com.example.demo.service.SellerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@Autowired
	UserSessionService userSessionService;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Seller> saveSeller(@Valid @RequestBody Seller seller) throws SellerException {
		
		Seller newSeller = sellerService.addSeller(seller);
		
		return new ResponseEntity<Seller>(newSeller ,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Seller> updateSeller(@Valid @RequestBody Seller seller) throws SellerException{
		
		Seller updatedSeller=sellerService.updateSeller(seller);
		
		return new ResponseEntity<Seller>(updatedSeller,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{sellerId}")
	public ResponseEntity<Seller> deleteSeller(@PathVariable("sellerId") Integer sellerId) throws SellerException{
		Seller removedSeller = sellerService.removeSeller(sellerId);
		return new ResponseEntity<Seller>(removedSeller, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{sellerId}")
	public ResponseEntity<Seller> getBySellerId(@PathVariable ("sellerId") Integer sellerId ,@RequestParam String key) throws SellerException, AuthorizationException{
		
		Integer sessionId = userSessionService.getUserSessionId(key);
    	
    	if(sessionId != null)
    		{	Seller seller =sellerService.viewSeller(sellerId);	
    			return new ResponseEntity<Seller>(seller ,HttpStatus.ACCEPTED);
    		}
    	else
    		throw new SellerException();
	}

}
