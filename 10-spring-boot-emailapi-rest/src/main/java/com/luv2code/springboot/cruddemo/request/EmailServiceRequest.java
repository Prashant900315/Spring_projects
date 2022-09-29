package com.luv2code.springboot.cruddemo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.luv2code.springboot.cruddemo.entity.EmailContent;
import com.luv2code.springboot.cruddemo.entity.EmailSubject;
import com.luv2code.springboot.cruddemo.entity.EmailUser;


@JsonIgnoreProperties(ignoreUnknown=true)
public class EmailServiceRequest {
	
	private EmailUser emailUser;
	private EmailContent emailContent;
	private EmailSubject emailSubject;

	public EmailServiceRequest()
	{
		
	}

	public EmailUser getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(EmailUser emailUser) {
		this.emailUser = emailUser;
	}

	public EmailContent getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(EmailContent emailContent) {
		this.emailContent = emailContent;
	}

	public EmailSubject getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(EmailSubject emailSubject) {
		this.emailSubject = emailSubject;
	}

	@Override
	public String toString() {
		return "EmailServiceRequest [emailUser=" + emailUser
				+ ", emailContent=" + emailContent + ", emailSubject="
				+ emailSubject + "]";
	}
	
	
}
