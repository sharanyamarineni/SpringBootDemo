package com.zemoso.springboot.cruddemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zemoso.springboot.cruddemo.converter.BookConverter;
import com.zemoso.springboot.cruddemo.dao.BookRepository;
import com.zemoso.springboot.cruddemo.dao.UserRepository;
import com.zemoso.springboot.cruddemo.dto.BookDto;
import com.zemoso.springboot.cruddemo.entity.Book;
import com.zemoso.springboot.cruddemo.entity.Item;


@Service
public class BookServiceImpl implements BookService {
	public BookRepository bookRepository;
	
	@Autowired
	public BookServiceImpl(BookRepository theBookRepository) {
		bookRepository = theBookRepository;
	}

	
	@Autowired
	BookConverter converter;
	
	@Override
	public List<BookDto> findAll() {
		List<Book> findAll = bookRepository.findAllByOrderByTitleAsc();
		return converter.entityToDto(findAll);
	}

	@Override
	public Book findById(int theId) {
//		Optional<Book> result = bookRepository.findById(theId);
//		
//
//		
//		if (result.isPresent()) {
//			return result.get();
//		}
//		else {
//			throw new RuntimeException("Did not find book id - " + theId);
//		}
	
		
		return bookRepository.findById(theId)
		        .orElseThrow(() -> new EntityNotFoundException("Did not find book id - " + theId));
		
	}

	@Override
	public void save(Book theBook) {
		bookRepository.save(theBook);
	}

	@Override
	public void deleteById(int theId) {
		bookRepository.deleteById(theId);
	}

	@Override
	public List<Book>  findByTitle(String keyword) {
		return bookRepository.findByTitle(keyword);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		bookRepository.deleteAll();
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return bookRepository.count();
	}

//	@Override
//	public List<Item> myCart(String name) {
//		List<Item> cartItems = new ArrayList<>();
//		userRepository.findByUsername(name).forEach(cartItems::add);
//
//	    return cartItems;
//	}


}
