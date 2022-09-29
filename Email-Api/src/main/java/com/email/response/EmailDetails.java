package com.email.response;

public class EmailDetails {
	
	private String username;
	private String subject;
	private String attachment;
	
	public EmailDetails()
	{
		
	}

	
	
	public EmailDetails(String username, String subject, String attachment) {
		this.username = username;
		this.subject = subject;
		this.attachment = attachment;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getAttachment() {
		return attachment;
	}



	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	

	
}
