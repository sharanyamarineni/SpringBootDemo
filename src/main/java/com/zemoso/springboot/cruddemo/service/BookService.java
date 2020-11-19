package com.zemoso.springboot.cruddemo.service;

import java.util.List;

import com.zemoso.springboot.cruddemo.dto.BookDto;
import com.zemoso.springboot.cruddemo.entity.Book;
import com.zemoso.springboot.cruddemo.entity.Item;

public interface BookService {
	public List<BookDto> findAll();
	
	public Book findById(int theId);
	
	public void save(Book theEmployee);
	
	public void deleteById(int theId);

	public List<Book>  findByTitle(String keyword);
	
	public void deleteAll();

	public long count();

	//public List<Item> myCart(String name);


}
