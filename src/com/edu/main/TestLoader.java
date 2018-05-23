package com.edu.main;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.builder.OrderBuilder;
import com.edu.domain.Order;
import com.edu.service.DeliveryService;
import com.edu.service.OrderService;
import com.edu.util.DateUtil;

public class TestLoader {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private DeliveryService deliveryService;
	
	public void createRecords() {
		Date date = new Date();
		Order od1 = new OrderBuilder()
				.withName("Fadejimi")
				.withAddress("103, Fairfield Rd")
				.withEmail("fadmandev@gmail.com")
				.withDeliveryDate(DateUtil.addHours(date, 5))
				.withOrderDate(DateUtil.addHours(date, -10))
				.withLocation("Fairfield")
				.builder();
		
		Order od2 = new OrderBuilder()
				.withName("Segun")
				.withAddress("104, Fairfield Rd")
				.withEmail("adegbulugbefadejimi@gmail.com")
				.withLocation("Fairfield")
				.withDeliveryDate(DateUtil.addHours(date, 2))
				.withOrderDate(DateUtil.addDays(date, 2))
				.builder();
		
		Order od3 = new OrderBuilder()
				.withName("Sade")
				.withAddress("104, Fairfield Rd")
				.withEmail("adegbulugbefadejimi@gmail.com")
				.withLocation("Fairfield")
				.withDeliveryDate(DateUtil.addHours(date, 2))
				.withOrderDate(DateUtil.addHours(date, 2))
				.builder();
		
		Order od4 = new OrderBuilder()
				.withName("Elham")
				.withAddress("104, Fairfield Rd")
				.withEmail("adegbulugbefadejimi@gmail.com")
				.withLocation("Fairfield")
				.withDeliveryDate(DateUtil.addHours(date, 2))
				.withOrderDate(DateUtil.addHours(date, 4))
				.builder();
		
		Order od5 = new OrderBuilder()
				.withName("Segun")
				.withAddress("104, Fairfield Rd")
				.withEmail("adegbulugbefadejimi@gmail.com")
				.withLocation("Fairfield")
				.withDeliveryDate(DateUtil.addHours(date, 2))
				.withOrderDate(DateUtil.addDays(date, 1))
				.builder();
		orderService.save(od1);
		orderService.save(od2);
		orderService.save(od3);
		orderService.save(od4);
		orderService.save(od5);
	}
}
