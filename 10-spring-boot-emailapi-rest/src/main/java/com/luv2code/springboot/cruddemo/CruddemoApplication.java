package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	/*@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder()
	{
	//	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	//	System.out.println("admin password is = " + encoder.encode("ADMIN"));
		return new BCryptPasswordEncoder();
	}*/
	
	

}
