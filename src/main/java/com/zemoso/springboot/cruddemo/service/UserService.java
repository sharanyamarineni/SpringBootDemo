package com.zemoso.springboot.cruddemo.service;

import java.util.List;

import javax.validation.Valid;

import com.zemoso.springboot.cruddemo.entity.Item;
import com.zemoso.springboot.cruddemo.entity.Users;

public interface UserService {
	public List<Item> myCart(String name);

	public void save(Users user);
}
