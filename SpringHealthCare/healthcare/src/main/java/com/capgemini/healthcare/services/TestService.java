package com.capgemini.healthcare.services;

import java.util.List;

import com.capgemini.healthcare.dto.TestDto;

public interface TestService {
	boolean addTest(TestDto dto);
	boolean deleteTest(String centerId);
	List<TestDto> viewAllTests();
	public boolean modifyTest(TestDto dto);
	public TestDto searchTest(int testId);
}
