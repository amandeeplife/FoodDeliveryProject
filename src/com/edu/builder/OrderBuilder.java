package com.edu.builder;

import java.util.Date;

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
	
	public OrderBuilder withAddress(String address) {
		this.order.setAddress(address);
		return this;
	}
	
	public OrderBuilder withEmail(String email) {
		this.order.setEmail(email);
		return this;
	}
	
	public OrderBuilder withOrderDate(Date date) {
		this.order.setOrderedDate(date);
		return this;
	}
	
	public OrderBuilder withDeliveryDate(Date date) {
		this.order.setDeliveryDate(date);
		return this;
	}
	
	public Order builder() {
		return order;
	}
}
