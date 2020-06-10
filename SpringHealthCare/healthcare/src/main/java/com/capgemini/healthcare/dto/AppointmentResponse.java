package com.capgemini.healthcare.dto;

import java.util.List;

public class AppointmentResponse {
	private int statusCode;
	private String message;
	private String discription;
	private List<AppointmentDto> beans;
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
	public List<AppointmentDto> getBeans() {
		return beans;
	}
	public void setBeans(List<AppointmentDto> beans) {
		this.beans = beans;
	}
}
