package com.zemoso.springboot.cruddemo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.zemoso.springboot.cruddemo.dto.BookDto;
import com.zemoso.springboot.cruddemo.entity.Book;

@Component
public class BookConverter {
	public BookDto entityToDto(Book book) {
		BookDto dto = new BookDto();
		dto.setId(book.getId());
		dto.setTitle(book.getTitle());
		dto.setAuthor_name(book.getAuthor_name());
		dto.setCategory(book.getCategory());
		dto.setPrice(book.getPrice());
		return dto;
	}
	public List<BookDto> entityToDto(List<Book> book){
		return book.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	public Book dtoToEntity(BookDto dto) {
		Book bk = new Book();
		bk.setId(dto.getId());
		bk.setTitle(dto.getTitle());
		bk.setAuthor_name(dto.getAuthor_name());
		bk.setCategory(dto.getCategory());
		bk.setPrice(dto.getPrice());
		return bk;
	}
	public List<Book> dtoToEntity(List<BookDto> dto){
		return dto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
}
