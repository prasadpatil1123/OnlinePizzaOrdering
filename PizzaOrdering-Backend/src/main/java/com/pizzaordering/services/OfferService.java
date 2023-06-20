package com.pizzaordering.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pizzaordering.model.Offer;

@Service
public interface OfferService {

	// Add Offer
	public Offer addOffer(Offer offer);

	// delete offer
	public void deleteOfferById(long id);

	// get Offer By Id
	public Optional<Offer> findOfferById(long id);

	// find all offers
	public List<Offer> findAllOffers();

	// Encapsulation
	// Edit Offer by id
	public Offer updateOffer(Offer offer);

}
