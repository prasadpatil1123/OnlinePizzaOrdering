package com.pizzaordering.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.stereotype.Repository;

import com.pizzaordering.model.Offer;

//@Repository
public interface OfferDao extends JpaRepository<Offer, Long> {

}
