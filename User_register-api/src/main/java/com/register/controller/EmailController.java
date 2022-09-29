package com.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;
import com.register.entity.EmailDetails;
import com.register.service.EmailService;

@RestController
@RequestMapping("/sendmail")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	    @PostMapping("/sendMail")
	    public String sendMail(@RequestBody EmailDetails details)
	    {
	        String status = emailService.sendSimpleMail(details);
	        return status;
	    }
	 
	    // Sending email with attachment
	    @PostMapping("/sendMailWithAttachment")
	    public String sendMailWithAttachment(@RequestBody EmailDetails details)
	    {
	        String status= emailService.sendMailWithAttachment(details);
	 
	        return status;
	    }

}
