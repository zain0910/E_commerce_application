package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.CategoryException;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException{
		Category newCategory = categoryService.addCategory(category);
		return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED); 
	}
	
	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException{
		Category updatedCategory = categoryService.updateCategory(category);
		return new ResponseEntity<Category>(updatedCategory, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view/{categoryId}")
	public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		Category category = categoryService.viewCategory(categoryId);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/remove/{categoryId}")
	public ResponseEntity<Category> removeCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException{
		Category removedCategory = categoryService.removeCategory(categoryId);
		return new ResponseEntity<Category>(removedCategory, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewall")
	public ResponseEntity<List<Category>> getAllCategories() throws CategoryException{
		List<Category> categories = categoryService.viewAllCategory();
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

}
