package com.edu.scheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edu.domain.Delivery;
import com.edu.domain.Order;
import com.edu.service.DeliveryService;
import com.edu.service.OrderService;

@Component
public class OrderScheduler {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	DeliveryService deliveryService;
	
	@Scheduled(fixedDelay = 10000)
	public void update() {
		List<Order> orders = orderService.findAllUndelivered();
		Map<String, List<Order>> groupOrders = new HashMap<>();
		
		for (Order order : orders) {
			if (groupOrders.containsKey(order.getLocation())) {
				groupOrders.get(order.getLocation()).add(order);
			}
			else {
				List<Order> tempOrder = new ArrayList<>();
				tempOrder.add(order);
				groupOrders.put(order.getLocation(), tempOrder);
			}
		}
		
		Iterator it = groupOrders.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<Order>> pair = (Map.Entry) it.next();
			
			List<Order> tempOrders = pair.getValue();
			Collections.sort(tempOrders, Collections.reverseOrder());
			
			Delivery delivery = new Delivery();
			delivery.setDeliveryDate(tempOrders.get(0).getDeliveryDate());
			for (Order ord : tempOrders) {
				ord.setOrderStatus(true);
				orderService.update(ord);
				delivery.addOrder(ord);
			}
			
			deliveryService.save(delivery);
		}
	}
	
}
