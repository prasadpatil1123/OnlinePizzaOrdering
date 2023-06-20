package com.pizzaordering.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaordering.dao.CategoryDao;
import com.pizzaordering.model.Category;

@Service
@Transactional
public class CategorysServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao categoryDao; 
	
	// 1. add category
	@Override
	public Category addCategory(Category category) {
		return categoryDao.save(category);
	}

	// 2. edit category by Id
	@Override
	public Category editCategoryById(Category category) {
		Category cat = this.categoryDao.findById(category.getId()).orElseThrow(()->new RuntimeException("Category not found"));
		cat.setCategoryName(category.getCategoryName());
		cat.setDescription(category.getDescription());
		return cat;
	}

	// 3. delete category by Id
	@Override
	public void deleteCategoryById(Long id) {
		categoryDao.deleteById(id);
	}

	// 4. get category by id
	@Override
	public Optional<Category> findCategoryById(Long id) {
		System.out.println("Finding the category with the Id : " + id);
		return categoryDao.findById(id);
	}

	// 5. get all category
	@Override
	public List<Category> allCategory() {
		return categoryDao.findAll();
	}

}
