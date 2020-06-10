package com.capgemini.healthcare.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.AdminDto;
import com.capgemini.healthcare.dto.AdminResponse;
import com.capgemini.healthcare.services.AdminService;

@RestController
	@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
	public class AdminController {
		@Autowired
		private  AdminService   adminservice;
		@PostMapping(path = "/loginAdmin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public  AdminResponse loginAdmin(@RequestBody AdminDto admin) {
			 AdminResponse adminresponse = new AdminResponse();
			 AdminDto dto = adminservice.loginAdmin(admin);
			if (dto!=null) {
				adminresponse.setStatusCode(201);
				adminresponse.setDiscription("Success");
				adminresponse.setMessage("Logged in");
				adminresponse.setBeans(Arrays.asList(dto));
				adminresponse.setRole(dto.getRole());
				
			}
			else {
				adminresponse.setStatusCode(401);
				adminresponse.setDiscription("Failure");
				adminresponse.setMessage("Credentials are not matching");
			}
			return adminresponse;
	}
}
