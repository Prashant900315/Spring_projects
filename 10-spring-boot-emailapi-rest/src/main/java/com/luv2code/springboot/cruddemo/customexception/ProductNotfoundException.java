package com.luv2code.springboot.cruddemo.customexception;


public class ProductNotfoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProductNotfoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductNotfoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductNotfoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
}
