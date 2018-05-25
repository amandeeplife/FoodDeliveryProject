package com.edu.service.test;

import static org.junit.Assert.assertEquals;

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
import com.edu.service.impl.OrderServiceImpl;
@ContextConfiguration("../../../././../resources/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
	@Resource	
	OrderService orderService = new OrderServiceImpl();
 
	 	 @Test
 	     @Rollback(true)
    public void testSave()
    {
	 		
	 	 	Order order = new Order();
	 	 	order.setName("pizza");
	 	   	orderService.save(order);
	 	   	
	 	    Long id = order.getId();
	 	    Assert.assertNotNull(id);
	 	    System.out.println(orderService.find(order.getId())+"Checking ");
	 	    List<Order> orders = orderService.findAll();

	 	    Order newOrder = orders.get(0);
	 	    Assert.assertEquals("pizza", newOrder.getName());
 
        return;
    }
	 	 
	 	 
	 	

	 	 @Test
	     @Transactional
	     @Rollback(true)
    public void testFindAll()
    {
    	Order order = new Order();
    	order.setEmail("aman.yahway@gmail.com");
    	order.setName("Bike");
    	
    	Order order2 = new Order();
    	order2.setEmail("aman.yahway@gmail.com");
    	order2.setName("Motor");
    	
    	orderService.save(order);
    	orderService.save(order2);

        List<Order> orders = orderService.findAll();
        Assert.assertEquals(2, orders.size());
        Order orderFromlist = orders.get(0);

        Assert.assertEquals("Bike", orderFromlist.getName());
        Assert.assertEquals("aman.yahway@gmail.com", orderFromlist.getEmail());
         
        return;
    }
	 	 
	 	@Test
		@Transactional
		@Rollback(true)
	   public void findOne()
	   {
	 		
	 	Order order = new Order();
	 	order.setName("cake");
	 	
	   	orderService.save(order);
	    Long id = order.getId();
	    
	    Assert.assertNotNull(id);
	    Order newDelivery = orderService.find(id);
	    Assert.assertEquals("cake", order.getName());
	    return;
	    
	   }
	 	 
}