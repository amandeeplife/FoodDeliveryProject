package com.edu.scheduler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edu.domain.Order;
import com.edu.service.OrderService;

@Component
public class OrderScheduler {
	
	@Autowired
	OrderService orderService;
	
	@Scheduled(cron = "0,0,*/3,*,*,*")
	public void update() {
		List<Order> orders = orderService.findAllUndelivered();
		Map<String, List<Order>> groupOrders = new HashMap<>();
		
		for (Order order : orders) {
			//if ()
		}
	}
	
}
