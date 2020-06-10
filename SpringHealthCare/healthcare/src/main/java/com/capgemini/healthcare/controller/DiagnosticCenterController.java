package com.capgemini.healthcare.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.healthcare.dto.DiagnosticCenterDto;
import com.capgemini.healthcare.dto.DiagnosticCenterResponse;
import com.capgemini.healthcare.services.DiagnosticCenterService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class DiagnosticCenterController {

	@Autowired
	private DiagnosticCenterService diagnosticCenterService;
	
	@PostMapping(path="/addCenter" ,produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse addCenter(@RequestBody DiagnosticCenterDto diagnosticCenterDto) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if(diagnosticCenterService.addCenter(diagnosticCenterDto)) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDiscription("Center added successfully");
			
		}else {
			diagnosticCenterResponse.setStatusCode(401);
			diagnosticCenterResponse.setMessage("Failure");
			diagnosticCenterResponse.setDiscription("Center id does not exist");
		}
		return diagnosticCenterResponse;
	}
	
	@DeleteMapping(path = "/deleteCenter/{centerId}",produces =  MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse deleteCenter(@PathVariable("centerId") String centerId) {
		DiagnosticCenterResponse response = new DiagnosticCenterResponse();
		
		if(diagnosticCenterService.deleteCenter(centerId)) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDiscription("Center Deatils Deleted");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDiscription("Center id does not exist");
		}
		return response;
	}
	@GetMapping(path = "/viewAllCenters", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse viewAllCustomers() {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		List<DiagnosticCenterDto> list = diagnosticCenterService.viewAllCenters();
		if (list.size() != 0) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDiscription("Centers are found");
			diagnosticCenterResponse.setBeans(list);
		} else {
			diagnosticCenterResponse.setStatusCode(401);
			diagnosticCenterResponse.setMessage("Failure");
			diagnosticCenterResponse.setDiscription("No data");
		}
		return diagnosticCenterResponse;

	}
	
	@PutMapping(path="/updateCenter", produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse modifyDiagnosticCenter(@RequestBody DiagnosticCenterDto dto) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		if(diagnosticCenterService.modifyDiagnosticCenter(dto)) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("success");
			diagnosticCenterResponse.setDiscription("Center name modified successfully");
		}
		return diagnosticCenterResponse;
	}
	@GetMapping(path = "/searchCenter/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DiagnosticCenterResponse searchCenter(@PathVariable("centerId") String centerId) {
		DiagnosticCenterResponse diagnosticCenterResponse = new DiagnosticCenterResponse();
		DiagnosticCenterDto dto = diagnosticCenterService.searchCenter(centerId);
		if (dto != null) {
			diagnosticCenterResponse.setStatusCode(201);
			diagnosticCenterResponse.setMessage("Success");
			diagnosticCenterResponse.setDiscription("center found");
			diagnosticCenterResponse.setBeans(Arrays.asList(dto));
		} else {
			diagnosticCenterResponse.setStatusCode(401);
			diagnosticCenterResponse.setMessage("Failure");
			diagnosticCenterResponse.setDiscription("center id does not exist");
		}
		return diagnosticCenterResponse;
	}

}
