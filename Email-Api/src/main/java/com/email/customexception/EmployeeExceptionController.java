package com.email.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.email.response.EmailServiceResponse;



@ControllerAdvice
public class EmployeeExceptionController {
	
	@ExceptionHandler
	ResponseEntity<CustomErrorException> exception(ProductNotfoundException exception)
	{
		CustomErrorException customErrorException = new
				CustomErrorException(exception.getMessage(),HttpStatus.NOT_FOUND.value(),System.currentTimeMillis());
		return new ResponseEntity<CustomErrorException>(customErrorException,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	ResponseEntity<CustomErrorException> exception(NumberFormatException exception)
	{
		CustomErrorException customErrorException = new
				CustomErrorException("Please Enter valid Id",HttpStatus.BAD_REQUEST.value(),System.currentTimeMillis());
		return new ResponseEntity<CustomErrorException>(customErrorException,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	ResponseEntity<EmailServiceResponse> exception(CourseNotFoundException exception)
	{
		EmailServiceResponse emailServiceResponse = new
				EmailServiceResponse(exception.getMessage(),HttpStatus.BAD_REQUEST.toString(),null);
		return new ResponseEntity<EmailServiceResponse>(emailServiceResponse,HttpStatus.BAD_REQUEST);
	}

}
