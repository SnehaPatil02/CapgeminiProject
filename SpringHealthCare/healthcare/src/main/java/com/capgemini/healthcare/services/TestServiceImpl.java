package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.DiagnosticCenterDao;
import com.capgemini.healthcare.dao.TestDao;
import com.capgemini.healthcare.dto.TestDto;
import com.capgemini.healthcare.exception.TestException;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao tdao;
	@Autowired
	private DiagnosticCenterDao dao;
	
	@Override
	public boolean addTest(TestDto dto) 
	{
		if(dao.searchCenter(dto.getCenterId()) == null)
		{
			throw new TestException("Center ID does not exist");
		}
		
		
		return tdao.addTest(dto);
		
	}

	@Override
	public boolean deleteTest(String centerId) {
		
		return tdao.deleteTest(centerId);
	}

	@Override
	public List<TestDto> viewAllTests() {
		
		return tdao.viewAllTests();
	}

	@Override
	public boolean modifyTest(TestDto dto) {
		
		return tdao.modifyTest(dto);
	}

	@Override
	public TestDto searchTest(int testId) {

		return tdao.searchTest(testId);
	}

}
