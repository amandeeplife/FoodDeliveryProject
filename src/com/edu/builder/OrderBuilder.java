package com.edu.builder;

import com.edu.domain.Order;

public class OrderBuilder {
	private Order order;
	
	public OrderBuilder() {
		order = new Order();
	}
	
	public OrderBuilder withName(String name) {
		this.order.setName(name);
		return this;
	}
}
