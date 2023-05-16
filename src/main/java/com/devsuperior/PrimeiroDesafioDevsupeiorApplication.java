package com.devsuperior;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.entities.Order;
import com.devsuperior.services.OrderService;

@SpringBootApplication
public class PrimeiroDesafioDevsupeiorApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimeiroDesafioDevsupeiorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("##########################");
		orderExample(new Order(1034, 150.00, 20.00));
		orderExample(new Order(2282, 800.00, 10.00));
		orderExample(new Order(1309, 95.90, 0.00));
	}
	
	private void orderExample(Order order) {
		System.out.println(String.format("Pedido código %d", order.getCode()));
		System.out.println(String.format("Valor total: R$ %s", orderService.total(order)));
		System.out.println("##########################");
	}

}
