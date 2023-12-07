package com.example.demo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.CartException;
import com.example.demo.exceptions.ItemException;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ItemRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository CartRepository;

	@Autowired
	ItemRepository itemRepository;
	
	
	@Override
	public Cart saveCart(Cart cart) throws CartException {
		Optional<Cart> optionalCart = CartRepository.findById(cart.getCartId());
		if(optionalCart.isPresent()) {
			throw new CartException("Cart already exists..");
		}else {
			 return CartRepository.save(cart);
		}
	}


	@Override
	public Cart clearCart(Integer cartId) throws CartException {
		Optional<Cart> optionalCart = CartRepository.findById(cartId);
		if(optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			CartRepository.delete(cart);
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}


	@Override
	public Cart viewCart(Integer cartId) throws CartException {
		Optional<Cart> optionalCart = CartRepository.findById(cartId);
		if(optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}


	@Override
	public Cart addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
		Optional<Cart> optionalCart = CartRepository.findById(cartId);
		if(optionalCart.isPresent()) {
			
			Optional<Item> optionalItem = itemRepository.findById(itemId);
			if(optionalItem.isPresent()) {
				
				Cart cart = optionalCart.get();
				Item item = optionalItem.get();
				List<Item> list = new ArrayList<>();
				list.addAll(cart.getItemList());
				list.add(item);
				cart.setItemList(list);
				
				return cart;
				
			}else {
				throw new ItemException("No Item found with ID: "+itemId);
			}
			
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}




}
