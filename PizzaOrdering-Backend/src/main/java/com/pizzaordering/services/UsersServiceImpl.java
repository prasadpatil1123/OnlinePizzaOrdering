package com.pizzaordering.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzaordering.dao.UsersDao;
import com.pizzaordering.exception.ResourceNotFoundException;
import com.pizzaordering.model.Users;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao usersDao;

	// Post => add new user(registration)
	@Override
	public Users addUsers(Users users) {
		return usersDao.save(users);
	}

	// Post => login
	@Override
	public Users login(String email, String password) {
		return usersDao.findByEmailAndPassword(email, password)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials !! , User not found!!!"));
	}

	// Get => edit/update user credential
	@Override
	public Users editUser(Users users) {
		Users foundUser = usersDao.findById(users.getId()).orElseThrow(() -> new RuntimeException("User not found"));
		// when user found
		foundUser.setEmail(users.getEmail());
		foundUser.setPassword(users.getPassword());
		foundUser.setFirstName(users.getFirstName());
		foundUser.setUserRole(users.getUserRole());
		foundUser.setMobileNo(users.getMobileNo());
//		foundUser.setId(users.getId());
		return usersDao.save(foundUser);
	}

	// Get => get all users data
	@Override
	public List<Users> getAllUsers() {
		return usersDao.findAll();
	}

	// Get => user by id
	@Override
	public Users getUsersById(long userid) {
		return usersDao.findById(userid).orElseThrow(() -> new ResourceNotFoundException("user not found"));
	}

	// Delete => delete user by id
	@Override
	public Users deleteUsers(long id) {
		usersDao.deleteById(id);
		return null;
	}

}
