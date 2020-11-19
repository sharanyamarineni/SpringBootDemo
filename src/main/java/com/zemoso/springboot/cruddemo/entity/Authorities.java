package com.zemoso.springboot.cruddemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="authorities")
public class Authorities {
	@Id
	@Column(name = "auth_username")
	private String username;
	@Column(name = "authority")
	private String authority;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
//	@ManyToMany(fetch=FetchType.LAZY,
//			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			 CascadeType.DETACH, CascadeType.REFRESH})
//	@JoinTable(
//			name="users_roles",
//			joinColumns=@JoinColumn(name="auth_username"),
//			inverseJoinColumns=@JoinColumn(name="username")
//			)	
//	private List<Users> users;
//	public List<Users> getUsers() {
//		return users;
//	}
//	public void setUsers(List<Users> users) {
//		this.users = users;
//	}
}
