package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="email_user")
public class EmailUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Transient
	private String flag;

	public EmailUser()
	{
		
	}
	public EmailUser(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}



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
    
	


	public String getFlag() {
		return flag;
	}



	public void setFlag(String flag) {
		this.flag = flag;
	}



	@Override
	public String toString() {
		return "EmailUser [username=" + username + ", password=" + password
				+ ", email=" + email + ", flag=" + flag + "]";
	}



	
}
