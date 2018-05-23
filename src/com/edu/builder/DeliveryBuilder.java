package com.edu.builder;

import java.util.Date;

import com.edu.domain.Delivery;
import com.edu.domain.Order;

public class DeliveryBuilder {
	private Delivery delivery;
	
	public DeliveryBuilder() {
		delivery = new Delivery();
	}
	
	public DeliveryBuilder withDeliveryDate(Date date) {
		this.delivery.setDeliveryDate(date);
		return this;
	}
	
	public DeliveryBuilder addOrder(Order order) {
		this.delivery.addOrder(order);
		return this;
	}
	
	public Delivery builder() {
		return this.delivery;
	}
}
