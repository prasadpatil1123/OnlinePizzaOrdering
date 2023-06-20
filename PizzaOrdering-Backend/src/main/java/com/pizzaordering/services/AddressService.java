package com.pizzaordering.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pizzaordering.model.Address;

@Service
public interface AddressService {

	Address addAddress(Address address);

	void deleteAddresssById(long id);

	Address editUsersAddress(Address address);

	Optional<Address> addressById(long id);

	List<Address> findAllAddress();

	Optional<Address> findByUsersId(long id);

	List<Address> getAddressByUsers(long id);

}
