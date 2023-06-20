package com.pizzaordering.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pizzaordering.model.Category;

@Service
public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category editCategoryById(Category category);
	
	void deleteCategoryById(Long id);
	
	public Optional<Category> findCategoryById(Long id);
	
	public List<Category> allCategory();

}
