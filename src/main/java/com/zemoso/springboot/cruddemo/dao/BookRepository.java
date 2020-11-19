package com.zemoso.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.zemoso.springboot.cruddemo.entity.Book;
import com.zemoso.springboot.cruddemo.entity.Item;

@RepositoryRestResource(path="books")
public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findAllByOrderByTitleAsc();
	public Boolean existsByTitle(String title);
	List<Book> findByTitle(String title);

	
	
}











