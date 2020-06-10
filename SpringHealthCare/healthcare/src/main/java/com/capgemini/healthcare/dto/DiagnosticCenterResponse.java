package com.capgemini.healthcare.dto;

import java.util.List;

public class DiagnosticCenterResponse {
	private int statusCode;
	private String message;
	private String discription;
	private List<DiagnosticCenterDto> beans;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public List<DiagnosticCenterDto> getBeans() {
		return beans;
	}
	public void setBeans(List<DiagnosticCenterDto> beans) {
		this.beans = beans;
	}
}
