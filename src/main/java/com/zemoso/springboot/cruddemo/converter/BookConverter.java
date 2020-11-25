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
		dto.setAuthorName(book.getAuthorName());
		dto.setCategory(book.getCategory());
		dto.setPrice(book.getPrice());
		return dto;
	}
	public List<BookDto> entityToDto(List<Book> book){
		return book.stream().map(this::entityToDto).collect(Collectors.toList());
	}
	public Book dtoToEntity(BookDto dto) {
		Book bk = new Book();
		bk.setId(dto.getId());
		bk.setTitle(dto.getTitle());
		bk.setAuthorName(dto.getAuthorName());
		bk.setCategory(dto.getCategory());
		bk.setPrice(dto.getPrice());
		return bk;
	}
	public List<Book> dtoToEntity(List<BookDto> dto){
		return dto.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
}
