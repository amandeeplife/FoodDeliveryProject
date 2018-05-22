package com.edu.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="food_orders")
public class Order implements Serializable, Comparable<Order>{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long Id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="location")
	private String location;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderedDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deliveryDate;
	
	@Column(name="orderStatus")
	private boolean orderStatus;
	
	public Order() {
		this.orderStatus = false;
		this.orderedDate = new Date();
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean deliveryStatus) {
		this.orderStatus = deliveryStatus;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (! (o instanceof Order)) return false;
		
		Order order = (Order) o;
		if (!name.equals(order.getName())) return false;
		if (!address.equals(order.getAddress())) return false;
		if (!location.equals(order.getLocation())) return false;
		if (!email.equals(order.getEmail())) return false;
		if (!orderedDate.equals(order.getOrderedDate())) return false;
		if (!deliveryDate.equals(order.getDeliveryDate())) return false;
		if (!(orderStatus == order.isOrderStatus())) return false;
		
		return true;
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(name, address, location, email, orderedDate, deliveryDate);
	}
	
	@Override
	public int compareTo(Order order) {
		return this.getDeliveryDate().compareTo(order.getDeliveryDate());
	}
}
