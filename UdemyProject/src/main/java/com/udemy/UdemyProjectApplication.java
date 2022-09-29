package com.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class UdemyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdemyProjectApplication.class, args);
	}

}
