package com.pizzaordering.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.pizzaordering.model.Review;

//@Repository
public interface ReviewDao extends JpaRepository<Review, Long> {

	List<Review> findByUsersId(long id);

	List<Review> findByPizzaId(long id);
}
