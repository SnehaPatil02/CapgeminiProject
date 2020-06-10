package com.capgemini.healthcare.dao;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.healthcare.dto.DiagnosticCenterDto;

@SpringBootTest
public class DiagnosticCenterDaoTest {

	@Autowired
	DiagnosticCenterDao dCenter;
	@Test
	public void addCenter() {
		DiagnosticCenterDto cDto = new DiagnosticCenterDto();
		cDto.setCenterId("Bims01");
		cDto.setCenterName("Bims");

		assertTrue(dCenter.addCenter(cDto));
		dCenter.deleteCenter("Bims01");
	}

	@Test
	public void deleteCenter() {
		DiagnosticCenterDto cDto = new DiagnosticCenterDto();
		cDto.setCenterId("Bims01");
		cDto.setCenterName("Bims");

		dCenter.addCenter(cDto);
		assertTrue(dCenter.deleteCenter("Bims01"));
	}

	@Test
	public void modifyDiagnosticCenter() {
		DiagnosticCenterDto cDto = new DiagnosticCenterDto();
		cDto.setCenterId("Bims01");
		cDto.setCenterName("Bims");

		dCenter.addCenter(cDto);
		assertTrue(dCenter.modifyDiagnosticCenter(cDto));
		dCenter.deleteCenter("Bims01");
	}

}
