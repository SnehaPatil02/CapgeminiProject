package com.capgemini.healthcare.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.healthcare.dto.AdminResponse;
import com.capgemini.healthcare.dto.AppointmentResponse;
import com.capgemini.healthcare.dto.DiagnosticCenterResponse;
import com.capgemini.healthcare.dto.TestResponse;
import com.capgemini.healthcare.exception.AdminException;
import com.capgemini.healthcare.exception.AppointmentException;
import com.capgemini.healthcare.exception.DiagnosticCenterException;
import com.capgemini.healthcare.exception.TestException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(AdminException.class)
	public AdminResponse handleAdminException (AdminException e) {
		AdminResponse adminResponse = new AdminResponse();
		adminResponse.setStatusCode(501);
		adminResponse.setMessage("Exception");
		adminResponse.setDiscription(e.getMessage());
		return adminResponse;
		
	}
	
	@ExceptionHandler(AppointmentException.class)
	public AppointmentResponse handleAppointmentException (AppointmentException e) {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		appointmentResponse.setStatusCode(501);
		appointmentResponse.setMessage("Exception");
		appointmentResponse.setDiscription(e.getMessage());
		return appointmentResponse;
		
	}
	
	@ExceptionHandler(DiagnosticCenterException.class)
	public DiagnosticCenterResponse handleDiagnosticCenterException (DiagnosticCenterException e) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		diagnosticCenterResponse.setStatusCode(501);
		diagnosticCenterResponse.setMessage("Exception");
		diagnosticCenterResponse.setDiscription(e.getMessage());
		return diagnosticCenterResponse;
		
	}
	
	@ExceptionHandler(TestException.class)
	public TestResponse handleTestException (TestException e) {
		TestResponse testResponse = new TestResponse();
		testResponse.setStatusCode(501);
		testResponse.setMessage("Exception");
		testResponse.setDiscription(e.getMessage());
		return testResponse;
		
	}
}
