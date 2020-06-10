package com.capgemini.healthcare.dao;

import java.util.List;

import com.capgemini.healthcare.dto.AppointmentDto;

public interface AppointmentDao {
	List<AppointmentDto> viewAllAppointments();
	public boolean approveAppointment(AppointmentDto aDto);

}
