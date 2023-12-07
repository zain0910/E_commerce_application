package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ItemException;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;

	
	
	@Override
	public Item addItem(Item item) throws ItemException {
		Optional<Item> optionalItem = itemRepository.findById(item.getItemId());
		if(optionalItem.isPresent()) {
			throw new ItemException("Item already exists..");
		}else {
			return itemRepository.save(item);
		}
	}



	@Override
	public Item updateItem(Item item) throws ItemException {
		Optional<Item> optionalItem = itemRepository.findById(item.getItemId());
		if(optionalItem.isPresent()) {
			return itemRepository.save(item);
		}else {
			throw new ItemException("No such Item found..");
		}
	}



	@Override
	public Item viewItem(Integer itemId) throws ItemException {
		Optional<Item> optionalItem = itemRepository.findById(itemId);
		if(optionalItem.isPresent()) {
			return optionalItem.get();
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}



	@Override
	public Item removeItem(Integer itemId) throws ItemException {
		Optional<Item> optionalItem = itemRepository.findById(itemId);
		if(optionalItem.isPresent()) {
			Item item = optionalItem.get();
			itemRepository.delete(item);
			return item;
		}else {
			throw new ItemException("No Item found with ID: "+itemId);
		}
	}



	@Override
	public List<Item> viewAllItems() throws ItemException {
		List<Item> items = itemRepository.findAll();
		if(items.size() > 0) {
			return items;
		}else {
			throw new ItemException("No Item exists..");
		}
	}
	
	

}

