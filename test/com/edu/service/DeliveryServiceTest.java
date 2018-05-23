package com.edu.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.domain.Delivery;
import com.edu.domain.Order;
import com.edu.service.OrderService;
import com.edu.service.impl.DeliveryServiceImpl;
import com.edu.service.impl.OrderServiceImpl;
@ContextConfiguration("../../../resources/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DeliveryServiceTest {
	@Resource	
	DeliveryService deliveryService = new DeliveryServiceImpl();
	Calendar myCalendar = new GregorianCalendar(2018, 2, 11);
	Date deliveryDate = myCalendar.getTime();
	
	 	 @Test
 	     @Rollback(true)
    public void testSave()
    {
	 		
	 	 	Delivery delivery = new Delivery();
	 	 	delivery.setDeliveryDate(deliveryDate);
	 	 	deliveryService.save(delivery);
	 	    List<Delivery> deliveries = deliveryService.findAll();
	 	    
	 	    Assert.assertEquals(1,deliveries.size());
 
        return;
    }
	 	 
	 	 
	 	

	 	 @Test
	     @Transactional
	     @Rollback(true)
    public void testFindAll()
    {
	 		Delivery delivery = new Delivery();
	 	 	delivery.setDeliveryDate(deliveryDate);
	 	 	
	 	 	Delivery delivery2 = new Delivery();
	 	 	delivery2.setDeliveryDate(deliveryDate);
  
	 	 	deliveryService.save(delivery);
	 	 	deliveryService.save(delivery2);
	 	 	
	 	 	List<Delivery> deliveries = deliveryService.findAll();
	 	 	Assert.assertEquals(2, deliveries.size());
	 	 	Delivery deliveryFromList = deliveries.get(0);

	 	    Assert.assertEquals(2,deliveries.size());
         
        return;
    }
	 	 
	 	@Test
		@Transactional
		@Rollback(true)
	   public void findOne()
	   {
	 		
	 		Delivery delivery = new Delivery();
	 	 	delivery.setDeliveryDate(deliveryDate);
	 	 	Order order = new Order();
	 	 	order.setName("cake");
	 	 	List<Order> orders = new ArrayList<Order>();
	 	 	orders.add(order);
	 	 	delivery.setOrders(orders);
	 	 	
	 	 	
	 	 	Delivery delivery2 = new Delivery();
	 	 	delivery2.setDeliveryDate(deliveryDate);
  
	 	 	deliveryService.save(delivery);
	 	 	deliveryService.save(delivery2);
	 	 	
	 	 	List<Delivery> deliveries = deliveryService.findAll();
	 	 	
	 	 	
	    Assert.assertEquals("cake", deliveries.get(1).getOrders().get(0).getName());
	    return;
	    
	   }
	 	 
}