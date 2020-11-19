package com.zemoso.springboot.cruddemo.dto;


public class BookDto {
	private int id;
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
	private String title;
	private String author_name;
	private String category;
	private Double price;
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}


}
