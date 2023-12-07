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
import com.example.demo.exceptions.CartException;
import com.example.demo.exceptions.ItemException;
import com.example.demo.model.Cart;
import com.example.demo.service.CartService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	UserSessionService userSessionService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Cart> saveCartDetails(@RequestParam String key,@RequestBody Cart fc) throws CartException, AuthorizationException
	{
				Integer sessionId = userSessionService.getUserSessionId(key);
				
				if(fc!=null && sessionId != null) {
	            Cart f= cartService.saveCart(fc);
	            	return new ResponseEntity<Cart>(f,HttpStatus.CREATED);
	            }
	            throw new CartException();
	}
	
	
	@PutMapping("/add/{cartId}/{itemId}")
	public ResponseEntity<Cart> addItemToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartException, ItemException{
		Cart updatedCart = cartService.addItem(cartId, itemId);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeCart(@PathVariable("cartId") Integer cartId) throws CartException{
		Cart removedCart = cartService.clearCart(cartId);
		return new ResponseEntity<Cart>(removedCart, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{cartId}")
	public Cart getCartByCartId(@PathVariable ("cartId") Integer cartId,@RequestParam String key) throws AuthorizationException, CartException{
		
		Integer sessionId = userSessionService.getUserSessionId(key);
		if(sessionId != null)
			return cartService.viewCart(cartId);
		else
			 throw new CartException();
			
	}

}

