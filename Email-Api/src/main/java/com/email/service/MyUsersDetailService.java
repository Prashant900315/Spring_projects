package com.email.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.email.Utils.GeneratePdfReport;
import com.email.Utils.Utility;
import com.email.customexception.CourseNotFoundException;
import com.email.dao.EmployeeDAO;
import com.email.entity.EmailContent;
import com.email.entity.EmailParameters;
import com.email.entity.EmailSubject;
import com.email.entity.EmailUser;
import com.email.request.EmailServiceRequest;
import com.email.response.EmailDetails;
import com.email.response.EmailServiceResponse;


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