package com.edu.service;

import java.util.List;

import com.edu.domain.Delivery;

public interface DeliveryService {
	public void save(Delivery delivery);
	public Delivery update(Delivery delivery);
	public List<Delivery> findAll();
	public List<Delivery> findAllUndelivered();
	public void delete(Delivery d);
	public Delivery find(Long id);
}
