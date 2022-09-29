package com.register.service;

import java.util.List;

import com.register.entity.MyUser;

public interface UserService {
	
	MyUser saveUser(MyUser user);
	
	MyUser updateUser(MyUser user,int ussrId);

	List<MyUser> getAllUser();
	
	MyUser getUserById(int Id);
	
	String deletUser(int Id);
	
	void sendMail(String username);
	
	

}
