package com.pizzaordering.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzaordering.dao.AddressDao;
import com.pizzaordering.dao.UsersDao;
import com.pizzaordering.model.Address;
//import com.pizzaordering.model.Users;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {


	@Autowired
	AddressDao addressDao; 
	
	@Autowired
	UsersDao usersDao;
	
	//Adding address................................
	@Override
	public Address addAddress(Address address) {
		addressDao.save(address);
		return address;
	}
	
	//Finding all address ...............
	@Override
	public List<Address> findAllAddress() {
		return addressDao.findAll();
	}
	
	//Getting address by users id.......
	@Override
	public List<Address> getAddressByUsers(long id) {
		return addressDao.findByUsersId(id).orElseThrow(()-> new RuntimeException("Address Not Found!"));
	}
	
	//Deleting address by id.................... 
	@Override
	public void deleteAddresssById(long id) {
	  addressDao.deleteById(id);
	 
	}
	//Finding users address by user id
	@Override
	public Optional<Address> findByUsersId(long id) {
//		return null;
			return	addressDao.findById(id);
	}
	
	
	
	@Override
	public Optional<Address> addressById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	//Editing address................................
	@Override
	public Address editUsersAddress(Address address) {
		Address foundUserAddress = addressDao.findById(address.getId()).orElseThrow(()->new RuntimeException("Address not Found"));
		foundUserAddress.setHouseNo(address.getHouseNo());
		foundUserAddress.setCity(address.getCity());
		foundUserAddress.setCountry(address.getCountry());
		foundUserAddress.setId(address.getId());
		foundUserAddress.setPincode(address.getPincode());
		foundUserAddress.setState(address.getState());
		foundUserAddress.setStreet(address.getStreet());
		return addressDao.save(foundUserAddress);
		
	}
}
