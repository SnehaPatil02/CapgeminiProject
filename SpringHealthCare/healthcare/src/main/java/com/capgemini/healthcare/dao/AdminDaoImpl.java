package com.capgemini.healthcare.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.AdminDto;
import com.capgemini.healthcare.exception.AdminException;
@Repository
public class AdminDaoImpl implements AdminDao
{
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public AdminDto loginAdmin(AdminDto dto) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try{
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
		String jpql = "from AdminDto where adminName=: adName and password=: pwd";
		TypedQuery<AdminDto> query = entityManager.createQuery(jpql, AdminDto.class);
		query.setParameter("adName", dto.getAdminName());
     	query.setParameter("pwd", dto.getPassword());
		
		AdminDto adminLogin = query.getSingleResult();
		if (adminLogin.getPassword().equals(dto.getPassword())) {
			return adminLogin;
		}
//			List<AdminLogin> loginBean = query.getResultList();
//			for (AdminLogin adminLogin : loginBean) {
//				if(adminLogin != null ) {
//					return loginBean;
//			}
//			}
		else {
			return null;
		}
		}catch(Exception e) {
			
		}
		entityManager.close();
		throw new AdminException("This name is not present");	
	}

}
