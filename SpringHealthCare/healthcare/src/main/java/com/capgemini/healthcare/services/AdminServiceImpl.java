package com.capgemini.healthcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcare.dao.AdminDao;
import com.capgemini.healthcare.dto.AdminDto;
import com.capgemini.healthcare.exception.AdminException;
import com.capgemini.healthcare.validations.Validations;

@Service
	public class AdminServiceImpl implements AdminService {
		@Autowired
		private AdminDao dao;
		@Override
		public AdminDto loginAdmin(AdminDto dto) {
			
			if(Validations.nameVal(dto.getAdminName())) { 
				if(Validations.passwordVal(dto.getPassword())) {
					
			return dao.loginAdmin(dto);
		} else {
			throw new AdminException("Enter correct credentials");
		}
			}
			else {
				throw new AdminException("Enter alphbaets only");
			}
		}
}
