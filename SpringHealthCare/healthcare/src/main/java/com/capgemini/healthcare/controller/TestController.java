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

import com.capgemini.healthcare.dto.TestDto;
import com.capgemini.healthcare.dto.TestResponse;
import com.capgemini.healthcare.services.TestService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	@PostMapping(path="/addTest" ,produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public TestResponse addTest(@RequestBody TestDto testDto) {
		TestResponse testResponse = new TestResponse();
		if(testService.addTest(testDto)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDiscription("Test added successfully");
			
		}
		return testResponse;
	}
	
	@DeleteMapping(path = "/deleteTest/{centerId}",produces =  MediaType.APPLICATION_JSON_VALUE)
	public TestResponse deleteTest(@PathVariable("testId") String centerId) {
		TestResponse response = new TestResponse();
		
		if(testService.deleteTest(centerId)) {
		response.setStatusCode(201);
		response.setMessage("Success");
		response.setDiscription("Test Deatils Deleted");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDiscription("Test id does not exist");
		}
		return response;
	}
	@GetMapping(path = "/viewAllTests", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse viewAllTests() {
		TestResponse testResponse = new TestResponse();
		List<TestDto> list = testService.viewAllTests();
		if (list.size() != 0) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDiscription("Tests are found");
			testResponse.setBeans(list);
		} else {
			testResponse.setStatusCode(401);
			testResponse.setMessage("Failure");
			testResponse.setDiscription("No data");
		}
		return testResponse;

	}
	
	@PutMapping(path="/modifyTest", produces =  MediaType.APPLICATION_JSON_VALUE,consumes =  MediaType.APPLICATION_JSON_VALUE)
	public TestResponse modifyTest(@RequestBody TestDto dto) {
		TestResponse testResponse = new TestResponse();
		if(testService.modifyTest(dto)) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("success");
			testResponse.setDiscription("Test is modified successfully");
		}
		return testResponse;
	}
	@GetMapping(path = "/searchTest/{testId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TestResponse searchTest(@PathVariable("testId") int testId) {
		TestResponse testResponse = new TestResponse();
		TestDto dto = testService.searchTest(testId);
		if (dto != null) {
			testResponse.setStatusCode(201);
			testResponse.setMessage("Success");
			testResponse.setDiscription("test found");
			testResponse.setBeans(Arrays.asList(dto));
		} else {
			testResponse.setStatusCode(401);
			testResponse.setMessage("Failure");
			testResponse.setDiscription("test id does not exist");
		}
		return testResponse;
	}

}
