package com.luv2code.springboot.cruddemo.response;

public class EmailServiceResponse {
	
	private String status;
	private String message;
	private EmailDetails emailDetails;
	
	public EmailServiceResponse()
	{
		
	}

	
	
	public EmailServiceResponse(String status, String message,
			EmailDetails emailDetails) {
		this.status = status;
		this.message = message;
		this.emailDetails = emailDetails;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmailDetails getEmailDetails() {
		return emailDetails;
	}

	public void setEmailDetails(EmailDetails emailDetails) {
		this.emailDetails = emailDetails;
	}
	
	

}
