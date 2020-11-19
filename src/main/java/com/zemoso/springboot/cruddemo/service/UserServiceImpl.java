package com.zemoso.springboot.cruddemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.springboot.cruddemo.dao.UserRepository;
import com.zemoso.springboot.cruddemo.entity.Item;
import com.zemoso.springboot.cruddemo.entity.Users;

@Service
public class UserServiceImpl implements UserService{
	public UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}
	@Override
	public List<Item> myCart(String name) {
		List<Item> cartItems = new ArrayList<>();
		userRepository.findByUsername(name).forEach(cartItems::add);

	    return cartItems;
	}
	@Override
	public void save(Users user) {
		userRepository.save(user);
		
	}

}
