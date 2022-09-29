package com.email.dao;

import com.email.entity.EmailContent;
import com.email.entity.EmailParameters;
import com.email.entity.EmailSubject;
import com.email.entity.EmailUser;
import java.util.List;

public interface EmployeeDAO {
	
public EmailUser findEmailByUsername(String username);
	
	public List<EmailSubject> findByEmailId(String subject);
	
	public EmailContent findByConentId(int theId);
	
	public List<EmailParameters> findByKey(String value);

}
