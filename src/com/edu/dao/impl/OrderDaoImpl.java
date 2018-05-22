package com.edu.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.edu.dao.OrderDao;
import com.edu.domain.Order;

 
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

	public OrderDaoImpl() {
		this.setDaoType(Order.class);
	}
	
	@Override
	public List<Order> findUndeliveredOrders() {
		// TODO Auto-generated method stub
		Date today = new Date();
		Query query =  entityManager.createQuery("from Order WHERE status = :status and date(deliveredDate) = :date");
		query.setParameter("status", 0);
		query.setParameter("date", today, TemporalType.DATE);
		return query.getResultList();
	}

}
