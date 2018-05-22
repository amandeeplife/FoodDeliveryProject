package com.edu.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.domain.Order;
import com.edu.service.OrderService;
import com.edu.service.impl.OrderServiceImpl;

public class OrderServiceTest {
	@Autowired
	OrderService orderService = new OrderServiceImpl();
	@Test
    public void testFindById()
    {
        Order order = orderService.find((long)1);

        assertEquals("Bike", order.getName());
        assertEquals("john.smith@mailinator.com", order.getEmail());
        
        return;
    }
    @Test
    public void testSave()
    {
    	Order order = new Order();
    	order.setEmail("aman.yahway@gmail.com");
    	order.setName("Bike");
    	orderService.save(order);
    	
        Long id = order.getId();
        Assert.assertNotNull(id);
        Order newOrder = orderService.find(id);

        Assert.assertEquals("Bike", newOrder.getName());
        Assert.assertEquals("aman.yahway@gmail.com", newOrder.getEmail());
 
        return;
    }

    @Test
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
        Assert.assertEquals(2, orders.size());
        Order orderFromlist = orders.get(0);

        Assert.assertEquals("Bike", orderFromlist.getName());
        Assert.assertEquals("aman.yahway@gmail.com", orderFromlist.getEmail());
         
        return;
    }
}