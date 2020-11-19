package com.zemoso.springboot.cruddemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zemoso.springboot.cruddemo.dao.BookRepository;

@SpringBootTest
class CruddemoApplicationTests {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testFind() {
		assertNotNull(bookRepository.findAll());
		Boolean result = bookRepository.existsByTitle("The Open Boat");
		assertEquals(result, true);
	}

}
