package com.capgemini.healthcare.exception;

public class DiagnosticCenterException extends RuntimeException {
	
	private String message;
	
	public DiagnosticCenterException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ExceptionHandling [message=" + message + "]";
	}


}
