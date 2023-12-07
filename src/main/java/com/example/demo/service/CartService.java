package com.example.demo.service;

import com.example.demo.exceptions.CartException;
import com.example.demo.exceptions.ItemException;
import com.example.demo.model.Cart;

public interface CartService {
	
	public Cart saveCart(Cart cart)throws CartException;
	
	public Cart addItem(Integer cartId, Integer itemId)throws CartException,ItemException;
	
	public Cart clearCart(Integer cartId)throws CartException;
	
	public Cart viewCart(Integer cartId)throws CartException;

}
