package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="email_parameters")
public class EmailParameters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="email_id")
	private int id;
	
	@Column(name="email_key")
	private String emailKey;
	
	@Column(name="email_value")
	private String emailValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailKey() {
		return emailKey;
	}

	public void setEmailKey(String emailKey) {
		this.emailKey = emailKey;
	}

	public String getEmailValue() {
		return emailValue;
	}

	public void setEmailValue(String emailValue) {
		this.emailValue = emailValue;
	}

	@Override
	public String toString() {
		return "EmailParameters [id=" + id + ", emailKey=" + emailKey
				+ ", emailValue=" + emailValue + "]";
	}

	
	
}
