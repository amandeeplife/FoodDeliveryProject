package com.edu.dao;

import java.util.List;

import com.edu.domain.Order;

public interface OrderDao extends GenericDao<Order> {
	public List<Order> findUndeliveredOrders();
}
