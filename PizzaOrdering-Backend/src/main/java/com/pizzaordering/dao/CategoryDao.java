package com.pizzaordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import com.pizzaordering.model.Category;

//@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

}
