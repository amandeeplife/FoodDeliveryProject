package com.edu.service;

import java.util.List;

import com.edu.domain.Order;

public interface OrderService {
	public void save(Order order);
	public Order update(Order order);
	public List<Order> findAll();
	public List<Order> findAllUndelivered();
	public void delete(Order order);
	public Order find(Long id);
}
