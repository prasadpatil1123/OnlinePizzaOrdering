package com.pizzaordering.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

import com.pizzaordering.model.Address;

//@Repository
public interface AddressDao extends JpaRepository<Address, Long> {
	
	Optional<List<Address>> findByUsersId(long id);
}
