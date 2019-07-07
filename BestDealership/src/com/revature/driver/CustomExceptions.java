package com.revature.driver;

public class CustomExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6894408712610948186L;
	public CustomExceptions(String message) {
		super(message);
		
	}
	
	public CustomExceptions(String message, Throwable throwable) {
		super(message, throwable);
		
	}

}
