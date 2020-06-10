package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.AppointmentDao;
import com.capgemini.healthcare.dto.AppointmentDto;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao dao;

	@Override
	public List<AppointmentDto> viewAllAppointments() {
		return dao.viewAllAppointments();
	}

	@Override
	public boolean approveAppointment(AppointmentDto aDto) {
		return dao.approveAppointment(aDto);
	}

	

}
