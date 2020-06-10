package com.capgemini.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.DiagnosticCenterDao;
import com.capgemini.healthcare.dao.TestDao;
import com.capgemini.healthcare.dto.DiagnosticCenterDto;
import com.capgemini.healthcare.dto.TestDto;
import com.capgemini.healthcare.exception.AdminException;
import com.capgemini.healthcare.exception.DiagnosticCenterException;
import com.capgemini.healthcare.validations.Validations;
@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService{
	@Autowired
	private DiagnosticCenterDao dao;
	@Autowired
	private TestDao tdao;
	
	@Override
	public boolean addCenter(DiagnosticCenterDto dto) {
		
	TestDto dto1 = new TestDto();
	dto1.setCenterId(dto.getCenterId());
	dto1.setTestName("Blood Group");
	tdao.addTest(dto1);
	
	TestDto dto2 = new TestDto();
	dto2.setCenterId(dto.getCenterId());
	dto2.setTestName("Blood Pressure");
	tdao.addTest(dto2);
	
	TestDto dto3 = new TestDto();
	dto3.setCenterId(dto.getCenterId());
	dto3.setTestName("Blood Sugar");
	tdao.addTest(dto3);
		return dao.addCenter(dto);
		
	}

	@Override
	public boolean deleteCenter(String centerId) {
		tdao.deleteTest(centerId);
		return dao.deleteCenter(centerId);
	}

	@Override
	public List<DiagnosticCenterDto> viewAllCenters() {
		return dao.viewAllCenters();
	}

	@Override
	public boolean modifyDiagnosticCenter(DiagnosticCenterDto dto) {
		
		return dao.modifyDiagnosticCenter(dto);
	} 

	@Override
	public DiagnosticCenterDto searchCenter(String centerId) {
		return dao.searchCenter(centerId);
	}

}
