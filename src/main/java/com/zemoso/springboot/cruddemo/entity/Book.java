package com.zemoso.springboot.cruddemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.zemoso.springboot.cruddemo.validation.NoDuplicates;


@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "title",unique = true)
	private String title;
	
	@NotNull(message="is required")	
	@Size(min=1,message = "is required")
	@Column(name = "author_name")
	private String author_name;
	
	@Column(name="price")
	private Double price;
	
	public Book() {
		
	}
	

	public Book(int id, String title,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String author_name, Double price,
			String category) {
	
		this.id = id;
		this.title = title;
		this.author_name = author_name;
		this.price = price;
		this.category = category;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author_name=" + author_name + ", price=" + price
				+ ", category=" + category + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "category")
	private String category;
}
