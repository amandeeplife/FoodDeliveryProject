package com.edu.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.service.OrderService;
import com.edu.service.impl.OrderServiceImpl;

public class OrderServiceTest {
	@Autowired
	OrderService os = new OrderServiceImpl();
	
	@Before
	public void saveOrder(){
		Order od  = new Order();
		od.setName("pen");
		od.setEmail("aman.yahway@gmail.com");
		od.setId(1);
		os.save(od);
	}
	
	
	@Test
    public void getOrder(){
		Order test = os.find((long) 1);
        assertEquals(test.getName(), "pen");
        assertEquals(test.getEmail(), "aman.yahway@gmail.com");
    }
}
