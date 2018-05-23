package com.edu.service;

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

import com.edu.domain.Order;
import com.edu.service.OrderService;
import com.edu.service.impl.OrderServiceImpl;
@ContextConfiguration("application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
   @Resource	
	OrderService orderService = new OrderServiceImpl();
	@Before
	public void saveData(){
		Order order = new Order();
		order.setEmail("aman.yahway@gmail.com");
		order.setName("Bike");
 		orderService.save(order);
	}
 
	 	 @Test
 	     @Rollback(true)
    public void testSave()
    {
    	Order order = new Order();
    	order.setEmail("aman.yahway@gmail.com");
    	order.setName("Bike");
    	orderService.save(order);
System.out.println(orderService.find((long)4));
        Long id = order.getId();
        Assert.assertNotNull(id);
        Order newOrder = orderService.find(id);

        Assert.assertEquals("Bike", newOrder.getName());
        Assert.assertEquals("aman.yahway@gmail.com", newOrder.getEmail());
 
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
    	order.setEmail("aman.yahway@gmail.com");
    	order.setName("Motor");
    	
    	orderService.save(order);
    	orderService.save(order2);

        List<Order> orders = orderService.findAll();
        Assert.assertEquals(3, orders.size());
        Order orderFromlist = orders.get(0);

        Assert.assertEquals("Bike", orderFromlist.getName());
        Assert.assertEquals("aman.yahway@gmail.com", orderFromlist.getEmail());
         
        return;
    }
}