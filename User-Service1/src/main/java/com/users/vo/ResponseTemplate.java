package com.users.vo;

import com.users.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
	
	private int status;
	private String msg;
	private User user;
	private Department dept;
	

}
