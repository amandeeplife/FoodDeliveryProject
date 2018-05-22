package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.dao.DeliveryDao;
import com.edu.domain.Delivery;
import com.edu.service.DeliveryService;

@Component
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	public DeliveryDao deliveryDao;
	
	@Override
	public void save(Delivery delivery) {
		// TODO Auto-generated method stub
		deliveryDao.save(delivery);
	}

	@Override
	public Delivery update(Delivery delivery) {
		// TODO Auto-generated method stub
		return deliveryDao.update(delivery);
	}

	@Override
	public List<Delivery> findAll() {
		// TODO Auto-generated method stub
		return deliveryDao.findAll();
	}

	@Override
	public List<Delivery> findAllUndelivered() {
		// TODO Auto-generated method stub
		return deliveryDao.findAllUndelivered();
	}

	@Override
	public void delete(Delivery d) {
		// TODO Auto-generated method stub
		deliveryDao.delete(d);
	}

	@Override
	public Delivery find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
