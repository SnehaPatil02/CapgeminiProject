package com.capgemini.healthcare.exception;

public class TestException extends RuntimeException {
	
	private String message;
	
	public TestException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionHandling [message=" + message + "]";
	}


}
