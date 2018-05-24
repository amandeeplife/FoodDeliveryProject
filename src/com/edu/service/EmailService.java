package com.edu.service;

import com.edu.domain.Order;

public interface EmailService {
public void sendOrderPlacementEmail(String to, Order od);
public void sendDeliveryConfirmationEmail(String to, Order od);
//public void testAOP(Order od);
}
