package com.capgemini.healthcare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.healthcare.dto.AppointmentDto;
import com.capgemini.healthcare.exception.AppointmentException;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Override
	public List<AppointmentDto> viewAllAppointments () {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			String jpql = "from AppointmentDto";
			Query query = entityManager.createQuery(jpql);
			List<AppointmentDto> list = query.getResultList();
			return list;
		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		return null;
	}
	@Override
	public boolean approveAppointment(AppointmentDto aDto) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			AppointmentDto appointment = entityManager.find(AppointmentDto.class, aDto);
			appointment.setAppointmentId(aDto.getAppointmentId());
			appointment.setCenterId(aDto.getCenterId());
			appointment.setTestName(aDto.getTestName());
			appointment.setUserId(aDto.getUserId());
			appointment.setUserName(aDto.getUserName());
			appointment.setDateTime(aDto.getDateTime());
			appointment.setStatus(aDto.getStatus());
			
			transaction.commit();
			return true;
		
		}catch (Exception e) {
			throw new AppointmentException("Please enter valid input");
		}
	}

}
