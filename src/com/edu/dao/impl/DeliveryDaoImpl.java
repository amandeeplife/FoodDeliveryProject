package com.edu.dao.impl;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.edu.dao.DeliveryDao;
import com.edu.domain.Delivery;
 
@Component
public class DeliveryDaoImpl extends GenericDaoImpl<Delivery> implements DeliveryDao{

	public DeliveryDaoImpl() {
		this.setDaoType(Delivery.class);
	}
	@Override
	public List<Delivery> findAllUndelivered() {
		// TODO Auto-generated method stub
		Date today = new Date();
		Query query =  entityManager.createQuery("from Delivery WHERE status = :status and date(deliveredDate) = :date");
		query.setParameter("status", 0);
		query.setParameter("date", today, TemporalType.DATE);
		return query.getResultList();
	}

}
