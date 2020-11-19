package com.zemoso.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zemoso.springboot.cruddemo.entity.Item;
import com.zemoso.springboot.cruddemo.entity.Users;

public interface UserRepository extends JpaRepository<Users, String>{
	List<Item> findByUsername(String name);

}
