package com.zemoso.springboot.cruddemo.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.springboot.cruddemo.converter.BookConverter;
import com.zemoso.springboot.cruddemo.dao.BookRepository;
import com.zemoso.springboot.cruddemo.dto.BookDto;
import com.zemoso.springboot.cruddemo.entity.Book;


@Service
public class BookServiceImpl implements BookService {
	public final BookRepository bookRepository;
	
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
		return bookRepository.findById(theId)
		        .orElseThrow(() -> new EntityNotFoundException("Did not find book id - " + theId));
		
	}

	@Override
	public void save(Book theBook) {
//		if(bookRepository.findByTitle(theBook.getTitle())!=null) {
//			System.out.println("list is present");
//		}

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
		bookRepository.deleteAll();
		
	}

	@Override
	public long count() {
		return bookRepository.count();
	}



}
