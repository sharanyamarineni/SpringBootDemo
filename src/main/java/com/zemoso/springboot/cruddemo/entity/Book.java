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
//	@NoDuplicates
	private String title;
	
	@NotNull(message="is required")	
	@Size(min=1,message = "is required")
	@Column(name = "author_name")
	//@Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
	private String authorName;
	
	@Column(name="price")
	private Double price;
	 @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	    @JoinColumn(name="user_id")
	    private Users users;
	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	public Book() {
		
	}
	

	public Book(int id, String title,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String authorName, Double price,
			String category) {
	
		this.id = id;
		this.title = title;
		this.authorName = authorName;
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
		return "Book [id=" + id + ", title=" + title + ", author_name=" + authorName + ", price=" + price
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


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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
