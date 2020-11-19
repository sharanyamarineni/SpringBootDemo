package com.zemoso.springboot.cruddemo.entity;

import java.util.List;
import java.util.Set;

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
@Table(name="users")
public class Users {
	@Id
	@Column(name="username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "enabled")
	private int enabled;
	@Column(name = "email")
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
//	@ManyToMany(fetch=FetchType.LAZY,
//			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//			 CascadeType.DETACH, CascadeType.REFRESH})
//	@JoinTable(
//			name="users_roles",
//			joinColumns=@JoinColumn(name="username"),
//			inverseJoinColumns=@JoinColumn(name="auth_username")
//			)
//	private List<Authorities> roles;
//	public List<Authorities> getRoles() {
//		return roles;
//	}
//	public void setRoles(List<Authorities> roles) {
//		this.roles = roles;
//	}
}
