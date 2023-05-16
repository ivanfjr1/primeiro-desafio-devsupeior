package com.devsuperior.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.entities.Order;

@Service
public class OrderService {
	
	@Autowired
	private ShippingService shippingService;
	
	public double total(Order order) {
		double totalDiscounted = order.getBasic() - (order.getBasic() * (order.getDiscount() / 100));
		double shipmentValue = shippingService.shipment(order);
		return totalDiscounted + shipmentValue;
	}
}
