package com.luv2code.springboot.cruddemo.Utils;

import com.luv2code.springboot.cruddemo.entity.EmailUser;

public class Utility {
	
	public String contentSetter(String content,EmailUser user)
	{
		String temp = content.replaceAll("<<USER_NAME>>", user.getUsername());
		return temp;
	}
	
	public String courseName(String course)
	{
		String setCourse = null;
		System.out.println(course);
		if(course.contains("Boot"))
			setCourse = "Spring Boot";
		if(course.contains("Core"))
			setCourse = "Spring core";
		if(course.contains("JPA"))
			setCourse = "JPA";
		if(course.contains("hibernate"))
			setCourse = "Hibernate";
		System.out.println(setCourse);
		return setCourse;
	}

}
