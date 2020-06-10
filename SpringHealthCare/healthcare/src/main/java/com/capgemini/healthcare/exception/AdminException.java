package com.capgemini.healthcare.exception;

public class AdminException extends RuntimeException {
	
	private String message;
	
	public AdminException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionHandling [message=" + message + "]";
	}

	

}
