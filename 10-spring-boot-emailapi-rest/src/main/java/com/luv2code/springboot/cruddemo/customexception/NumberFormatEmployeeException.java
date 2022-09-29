package com.luv2code.springboot.cruddemo.customexception;

public class NumberFormatEmployeeException extends NumberFormatException{

	private static final long serialVersionUID = 1083571838710465297L;

	public NumberFormatEmployeeException() {
		super();
	}

	public NumberFormatEmployeeException(String s) {
		super(s);
	}

	
	
}
