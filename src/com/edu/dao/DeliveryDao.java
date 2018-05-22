package com.edu.dao;

import java.util.List;

import com.edu.domain.Delivery;

public interface DeliveryDao extends GenericDao<Delivery>{
	List<Delivery> findAllUndelivered();
}
