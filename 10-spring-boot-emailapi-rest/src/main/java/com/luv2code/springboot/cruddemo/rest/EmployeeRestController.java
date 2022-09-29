package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAOHibernateImpl;
import com.luv2code.springboot.cruddemo.entity.EmailContent;
import com.luv2code.springboot.cruddemo.entity.EmailSubject;
import com.luv2code.springboot.cruddemo.entity.EmailUser;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.request.EmailServiceRequest;
import com.luv2code.springboot.cruddemo.response.EmailDetails;
import com.luv2code.springboot.cruddemo.response.EmailServiceResponse;
import com.luv2code.springboot.cruddemo.service.MailGenerator;
import com.luv2code.springboot.cruddemo.service.MyUsersDetailService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private MyUsersDetailService myUsersDetailService;
	
	@Autowired
	private MailGenerator mail;
	
	@Autowired
    EmployeeDAOHibernateImpl EmployeeDao;
	
	@GetMapping("/employees/email/{user}")
	public EmailUser findByEmailUsername(@PathVariable String user)
	{
		
		return myUsersDetailService.findByEmailUsername(user);
	}
	
	@GetMapping("/email/{user}")
	public EmailUser sendEmail(@PathVariable String user)
	{
		EmailUser userE = myUsersDetailService.findByEmailUsername(user);
		System.out.println("find by username==="+userE);
		return myUsersDetailService.sendEmailTest(userE);
	}
	
	@PostMapping("/email/sendEmail")
	public EmailServiceResponse sendEmailCourseWise(@RequestBody EmailServiceRequest emailServiceRequest ) throws MailException, MessagingException
	{
		return myUsersDetailService.sendEmailCourseWise(emailServiceRequest);
	}
	
	

}
