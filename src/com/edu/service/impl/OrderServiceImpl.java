package com.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.dao.OrderDao;
import com.edu.domain.Order;
import com.edu.service.OrderService;

 
public class OrderServiceImpl implements OrderService{

	@Autowired
	public OrderDao orderDao;
	
	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return orderDao.update(order);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public List<Order> findAllUndelivered() {
		// TODO Auto-generated method stub
		return orderDao.findUndeliveredOrders();
	}

	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		orderDao.delete(order);
	}

	@Override
	public Order find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
