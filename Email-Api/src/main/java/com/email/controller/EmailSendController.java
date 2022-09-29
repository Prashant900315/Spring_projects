package com.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.dao.EmployeeDAOHibernateImpl;
import com.email.entity.EmailUser;
import com.email.request.EmailServiceRequest;
import com.email.response.EmailServiceResponse;
import com.email.service.MailGenerator;
import com.email.service.MyUsersDetailService;

@RestController
@RequestMapping("/mail")
public class EmailSendController {
	
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
