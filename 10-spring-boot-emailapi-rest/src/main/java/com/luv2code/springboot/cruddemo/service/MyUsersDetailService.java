package com.luv2code.springboot.cruddemo.service;


import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.Utils.GeneratePdfReport;
import com.luv2code.springboot.cruddemo.Utils.Utility;
import com.luv2code.springboot.cruddemo.customexception.CourseNotFoundException;
import com.luv2code.springboot.cruddemo.customexception.ProductNotfoundException;
import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.EmailContent;
import com.luv2code.springboot.cruddemo.entity.EmailParameters;
import com.luv2code.springboot.cruddemo.entity.EmailSubject;
import com.luv2code.springboot.cruddemo.entity.EmailUser;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.request.EmailServiceRequest;
import com.luv2code.springboot.cruddemo.response.EmailDetails;
import com.luv2code.springboot.cruddemo.response.EmailServiceResponse;


@Service
public class MyUsersDetailService{
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private MailGenerator mailGenerator;
	
	
	
	@Transactional
	public EmailUser findByEmailUsername(String username)
	{
		System.out.println("username is" + username);
		
		EmailUser email = employeeDAO.findEmailByUsername(username);
		
		if(email==null)
		{
			throw new CourseNotFoundException("Email user not valid for username: " + username);
		}
		
		return employeeDAO.findEmailByUsername(username);
	}
	
	
	public EmailUser sendEmailTest(EmailUser emailUser)
	{
		mailGenerator.sendEmail(emailUser);
		return emailUser;
	}
	
	
	@Transactional
	public EmailContent findByConentId(int theId)
	{
		//System.out.println("username is" + username);
		
		EmailContent content = employeeDAO.findByConentId(theId);
		
		if(content==null)
		{
			throw new CourseNotFoundException("Content not valid for id: " + theId);
		}
		
		return content;
	}
	
	@Transactional
	public List<EmailSubject> findByEmailId(String subject)
	{
		System.out.println("subject is" + subject);
		
		List<EmailSubject> subj = employeeDAO.findByEmailId(subject);
		
		if(subj.isEmpty())
		{
			throw new CourseNotFoundException("Please Enter Valid Topic");
		}
		System.out.println("subj is" + subj);
		return subj;
	}
	
	@Transactional
	public List<EmailParameters> findByKey(String value)
	{
		//System.out.println("username is" + username);
		
		List<EmailParameters> subj = employeeDAO.findByKey(value);
		
		if(subj.isEmpty())
		{
			throw new CourseNotFoundException("Please Enter Valid value");
		}
		
		return subj;
	}
	

	
	public EmailServiceResponse sendEmailCourseWise(EmailServiceRequest emailServiceRequest) throws MailException, MessagingException
	{
		
	  String subj=null;	
	  
	  String attachment=null;
		
	  Utility util = new Utility();
		
	  EmailServiceResponse emailServiceResponse = new EmailServiceResponse();
	  
      EmailUser user = findByEmailUsername(emailServiceRequest.getEmailUser().getUsername());
      
      EmailContent content = findByConentId(emailServiceRequest.getEmailContent().getId());
      
      List<EmailParameters> emailParam = findByKey(emailServiceRequest.getEmailSubject().getSubjectTopic());
      
      for(EmailParameters sub:emailParam)
      {
      subj = sub.getEmailKey();
      }
      List<EmailSubject> subject = findByEmailId(subj);
      String modifiedContent = util.contentSetter(content.getEmailContent(),user);
      
      System.out.println("modifiedContent is = " + modifiedContent);
      
      String attachmentFlag = emailServiceRequest.getEmailUser().getFlag();
      
      
      emailServiceRequest.getEmailContent().setEmailContent(modifiedContent);
      for(EmailSubject list:subject)
      {
      emailServiceRequest.getEmailSubject().setSubject(list.getSubject());
      }
      emailServiceRequest.getEmailUser().setEmail(user.getEmail());
      
      System.out.println("emailServiceRequest is = " + emailServiceRequest);
      
      // Send Attachment: No
      if(attachmentFlag.equalsIgnoreCase("N"))
      {
      mailGenerator.sendEmail(emailServiceRequest);
      attachment="Not Included";
      }
      // Send Attachment: Yes
      if(attachmentFlag.equalsIgnoreCase("Y"))
      {
      // Calling PDF Generator method
      GeneratePdfReport report = new GeneratePdfReport();
      report.pdfReport(emailServiceRequest);
      attachment="Included";
      
      // Sending Email with attachment
      mailGenerator.sendEmailWithAttachment(emailServiceRequest);
      }
      emailServiceResponse.setMessage("Email Sent Successfully");
      emailServiceResponse.setStatus(HttpStatus.OK.toString());
      emailServiceResponse.setEmailDetails(new EmailDetails(user.getUsername(),emailServiceRequest.getEmailSubject().getSubject(),attachment));
	  return emailServiceResponse;
	}
	
	

}
