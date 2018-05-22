package com.edu.scheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edu.domain.Delivery;
import com.edu.service.DeliveryService;

@Component
public class DeliveryScheduler {
	public static final long HOUR = 3600*1000;
	@Autowired
	public DeliveryService deliveryService;
	
	@Scheduled(fixedDelay = 50000)
	public void publish() {
		List<Delivery> deliveries = deliveryService.findAllUndelivered();
		Date date = new Date();
		for (Delivery del : deliveries) {
			if (date.before(del.getDeliveryDate())) {
				Date newDate = new Date(del.getDeliveryDate().getTime() + 1 * HOUR);
				del.setDeliveryDate(newDate);
				deliveryService.update(del);
			}
			else {
				del.setStatus(true);
				deliveryService.update(del);
			}
		}
	}
}
