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
import com.capgemini.healthcare.exception.TestException;
@Repository
public class TestDaoImpl implements TestDao{
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addTest(TestDto dto) {
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

		
		throw new TestException("This ID is not present");
	}

	@Override
	public boolean deleteTest(String centerId) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "delete from TestDto where centerId=: centerId";
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
	public List<TestDto> viewAllTests() {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			String jpql = "from TestDto";
			Query query = entityManager.createQuery(jpql);
			List<TestDto> list = query.getResultList();
			return list;
		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		return null;

	}
	@Override
	public boolean modifyTest(TestDto dto) {
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			TestDto tDto = entityManager.find(TestDto.class, dto.getTestId());
			tDto.setTestId(dto.getTestId());
			tDto.setTestName( dto.getTestName());
			tDto.setCenterId(dto.getCenterId());
			transaction.commit();
			return true;
		
		}catch(Exception e) {
			transaction.rollback();

		}
		entityManager.close();
		throw new TestException("This ID is not present");
	
	}
	@Override
	public TestDto searchTest(int testId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TestDto dto = entityManager.find(TestDto.class, testId);
		return dto;
	
	}
}
