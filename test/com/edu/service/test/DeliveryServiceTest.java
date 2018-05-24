package com.edu.service.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.edu.service.DeliveryService;
import com.edu.service.OrderService;
import com.edu.service.impl.DeliveryServiceImpl;
import com.edu.service.impl.OrderServiceImpl;
@ContextConfiguration("application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DeliveryServiceTest {

	Date deliveryDate;
	
   @Resource	
	DeliveryService deliveryService = new DeliveryServiceImpl();
	@Before
	public void saveData() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		deliveryDate = sdf.parse(dateInString);	
		 
	}
 
	 	 @Test
 	     @Rollback(true)
    public void testSave()
    {
    	Delivery delivery = new Delivery();
    	Order od = new Order();
    	Order od2 = new Order();
    	List<Order> orders= new ArrayList<Order>();
    	orders.add(od);
    	orders.add(od2);
    	delivery.setDeliveryDate(deliveryDate);
    	delivery.setOrders(orders);
    	deliveryService.save(delivery);
        Long id = delivery.getId();
        Assert.assertNotNull(id);
        Delivery newDelivery = deliveryService.find(id);

        Assert.assertEquals("31-08-1982 10:20:56", newDelivery.getDeliveryDate());
        Assert.assertEquals("2", newDelivery.getOrders().size());
 
        return;
    }

	 	 @Test
	     @Transactional
	     @Rollback(true)
    public void testFindAll()
    {
	 		Delivery delivery = new Delivery();
	 		Order od = new Order();
	 		od.setName("book");
	    	Order od2 = new Order();
	    	List<Order> orders= new ArrayList<Order>();
	    	orders.add(od);
	    	orders.add(od2);
	    	delivery.setOrders(orders);
	    	
	    	Delivery delivery2 = new Delivery();
	    	deliveryService.save(delivery);
	    	deliveryService.save(delivery2);

        List<Delivery> deliveries = deliveryService.findAll();
        Assert.assertEquals(2, deliveries.size());
        Delivery deliveryFromList = deliveries.get(0);

        Assert.assertEquals("book", deliveryFromList.getOrders().get(0).getName());
        
         
        return;
    }
}