package com.luv2code.springboot.cruddemo.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.entity.EmailUser;
import com.luv2code.springboot.cruddemo.request.EmailServiceRequest;

@Service
public class MailGenerator {
	
	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	/*@Autowired
	public MailGenerator(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}*/

	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(EmailUser emailUser) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("prashantraghav145@gmail.com");
		mail.setTo(emailUser.getEmail());
		mail.setSubject("Hii This is Raghav");
		System.out.println(emailUser.getEmail());
		mail.setText("Hurray ! Katori devi kaise hu[ppppppp...");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	
	public void sendEmail(EmailServiceRequest emailServiceRequest) throws MailException, MessagingException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	//	SimpleMailMessage mail = new SimpleMailMessage();
		helper.setTo(emailServiceRequest.getEmailUser().getEmail());
		helper.setSubject(emailServiceRequest.getEmailSubject().getSubject());
		System.out.println(emailServiceRequest.getEmailUser().getEmail());
		System.out.println(emailServiceRequest.getEmailSubject().getSubject());
		System.out.println(emailServiceRequest.getEmailContent().getEmailContent());
		helper.setText(emailServiceRequest.getEmailContent().getEmailContent(),true);
		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mimeMessage);
	}

	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param user
	 * @throws MailException
	 * @throws MessagingException
	 */
	public void sendEmailWithAttachment(EmailServiceRequest emailServiceRequest) throws MailException, MessagingException {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setTo(emailServiceRequest.getEmailUser().getEmail());
		helper.setSubject(emailServiceRequest.getEmailSubject().getSubject());
		helper.setText(emailServiceRequest.getEmailContent().getEmailContent(),true);
	
		
		//ClassPathResource classPathResource = new ClassPathResource("C:\\pdf\\newfile.pdf");
		//helper.addAttachment(classPathResource.getFilename(), classPathResource);
		String url = "C:\\pdf\\"+emailServiceRequest.getEmailUser().getUsername()+".pdf";
		File file = new File(url); 
		helper.addAttachment(file.getName(), file);

		javaMailSender.send(mimeMessage);
	}
	

}
