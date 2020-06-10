package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.DiagnosticCenterDto;
import com.capgemini.healthcare.dto.TestDto;
import com.capgemini.healthcare.exception.DiagnosticCenterException;
import com.capgemini.healthcare.exception.TestException;
@Repository
public class DiagnosticCenterDaoImpl implements DiagnosticCenterDao {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public boolean addCenter(DiagnosticCenterDto dto) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(dto);
			transaction.commit();
			return true;
		}catch(Exception e) {
			transaction.rollback();
			
		}
		entityManager.close();

		
		throw new DiagnosticCenterException("This ID is not present");
	}

	@Override
	public boolean deleteCenter(String centerId) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "delete from DiagnosticCenterDto where centerId=: centerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("centerId", centerId);
			int i = query.executeUpdate();
			transaction.commit();
			if(i > 0) {
				return true;
			} 

			throw new TestException("This ID is not present");
	}

	@Override
	public List<DiagnosticCenterDto> viewAllCenters() {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			String jpql = "from DiagnosticCenterDto";
			Query query = entityManager.createQuery(jpql);
			List<DiagnosticCenterDto> list = query.getResultList();
			return list;
		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		return null;

	
	}

	@Override
	public boolean modifyDiagnosticCenter(DiagnosticCenterDto dto) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			DiagnosticCenterDto cDto = entityManager.find(DiagnosticCenterDto.class, dto.getCenterId());
			cDto.setCenterId(dto.getCenterId());
			cDto.setCenterName(dto.getCenterName());
			transaction.commit();
			return true;
		}catch(Exception e) {
			transaction.rollback();

		}
		entityManager.close();
		throw new DiagnosticCenterException("This ID is not present");
	
	}

	@Override
	public DiagnosticCenterDto searchCenter(String centerId) {
		
		EntityManager manager = entityManagerFactory.createEntityManager();
		
		DiagnosticCenterDto dto = manager.find(DiagnosticCenterDto.class, centerId);
		
			return dto;
		
	}
	
	
}
