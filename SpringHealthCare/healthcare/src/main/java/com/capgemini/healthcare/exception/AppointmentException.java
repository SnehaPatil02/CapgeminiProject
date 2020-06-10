package com.capgemini.healthcare.exception;

public class AppointmentException extends RuntimeException {
	
	private String message;
	
	public AppointmentException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionHandling [message=" + message + "]";
	}


}
