package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.register.entity.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
	
	@Query(value="select parameterValue from ParameterMST	where parameterKey= 'SMTP_HOST' ")
	public String getSMTPHost();

}
