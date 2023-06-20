package com.pizzaordering.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaordering.dao.OfferDao;
import com.pizzaordering.exception.ResourceNotFoundException;
import com.pizzaordering.model.Offer;

@Service
@Transactional
@Component
public class OfferServiceImpl implements OfferService {

	@Autowired
	OfferDao offerDao;

	// Add Offer
	@Override
	public Offer addOffer(Offer offer) {
		offerDao.save(offer);
		return offer;
	}

	// delete offer
	@Override
	public void deleteOfferById(long id) {
		System.out.println("Finding the offer with the Id: " + id);
		offerDao.deleteById(id);
	}

	// get Offer By Id
	@Override
	public Optional<Offer> findOfferById(long id) {
		System.out.println("Finding the offer with the Id: " + id);
		return offerDao.findById(id);
		// return offerDao.findById(id).orElseThrow(()-> new
		// ResourceNotFoundException("Invalid id, plz enter valid id."));
	}

	// find all offers
	@Override
	public List<Offer> findAllOffers() {
		return offerDao.findAll();
	}

	//Encapsulation
	//Edit Offer by id
	@Override
	public Offer updateOffer(Offer offer) {
		Offer updOffer = this.offerDao.findById(offer.getId()).orElseThrow(()-> new ResourceNotFoundException("Please enter valid id"));
		
		//we update data by setter getter(Encapsulation)
//		updOffer.setName(offer.getName());
		updOffer.setDiscount(offer.getDiscount());
		updOffer.setValidForm(offer.getValidForm());
		updOffer.setValidUpto(offer.getValidUpto());
		updOffer.setCode(offer.getCode());
		updOffer.setTermsCondition(offer.getTermsCondition());
		return offerDao.save(updOffer); //finally save it
	}

}
