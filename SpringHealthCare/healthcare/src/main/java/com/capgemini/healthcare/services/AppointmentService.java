package com.capgemini.healthcare.services;

import java.util.List;

import com.capgemini.healthcare.dto.AppointmentDto;

public interface AppointmentService {
	public List<AppointmentDto> viewAllAppointments ();
	public boolean approveAppointment(AppointmentDto aDto);

}
