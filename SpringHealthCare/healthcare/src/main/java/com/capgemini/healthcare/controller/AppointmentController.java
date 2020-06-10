package com.capgemini.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.dto.AppointmentResponse;
import com.capgemini.healthcare.services.AppointmentService;


@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	
	@GetMapping(path = "/viewAllAppointments", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse viewAllAppointments() {
		AppointmentResponse appointmentResponse = new AppointmentResponse();
		List<AppointmentDto> list = appointmentService.viewAllAppointments();
		if (list.size() != 0) {
			appointmentResponse.setStatusCode(201);
			appointmentResponse.setMessage("Success");
			appointmentResponse.setDiscription("Appointments are found");
			appointmentResponse.setBeans(list);
		} else {
			appointmentResponse.setStatusCode(401);
			appointmentResponse.setMessage("Failure");
			appointmentResponse.setDiscription("No data");
		}
		return appointmentResponse;

	}
	@PutMapping(path = "/approveAppointment/", produces = MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public AppointmentResponse approveAppointment(@RequestBody AppointmentDto appointmentDto ) {
		AppointmentResponse response = new AppointmentResponse();
		if(appointmentService.approveAppointment(appointmentDto)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDiscription("Center Deatils Deleted");
			
			}
			return response;

	}
}
