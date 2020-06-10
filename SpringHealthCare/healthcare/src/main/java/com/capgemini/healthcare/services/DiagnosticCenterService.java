package com.capgemini.healthcare.services;

import java.util.List;

import com.capgemini.healthcare.dto.DiagnosticCenterDto;

public interface DiagnosticCenterService {
	boolean addCenter(DiagnosticCenterDto dto);
	boolean deleteCenter(String centerId);
	List<DiagnosticCenterDto> viewAllCenters();
	public boolean modifyDiagnosticCenter(DiagnosticCenterDto dto);
	public DiagnosticCenterDto searchCenter(String centerId);
}
