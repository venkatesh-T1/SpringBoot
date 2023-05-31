package com.infy.irs.exception;

public class UserIdAlreadyPresentException extends InfyGoBookException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserIdAlreadyPresentException(String message) {
		
		super(message);
	}
}
