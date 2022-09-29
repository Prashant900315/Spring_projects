package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.EmailContent;
import com.luv2code.springboot.cruddemo.entity.EmailParameters;
import com.luv2code.springboot.cruddemo.entity.EmailSubject;
import com.luv2code.springboot.cruddemo.entity.EmailUser;
import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public EmailUser findEmailByUsername(String username);
	
	public List<EmailSubject> findByEmailId(String subject);
	
	public EmailContent findByConentId(int theId);
	
	public List<EmailParameters> findByKey(String value);
}
