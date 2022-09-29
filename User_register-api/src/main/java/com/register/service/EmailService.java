package com.register.service;

import com.register.entity.EmailDetails;


public interface EmailService {
	
    String sendSimpleMail(EmailDetails details);
 
    String sendMailWithAttachment(EmailDetails details);

}
