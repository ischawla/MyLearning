package com.example.publisher;

import com.example.config.MessagingConfig;
import com.example.dto.Order;
import com.example.dto.OrderStatus;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("order")
public class OrderPublisher {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	TopicExchange exchange;
	
	@Autowired
	Queue queue;
	
	
	 @PostMapping("/{restaurantName}")
	 public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
	        order.setOrderId(UUID.randomUUID().toString());
	        //restaurantservice
	        //payment service
	       // OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
	        //rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE_NAME, MessagingConfig.ROUTING_KEY, orderStatus);
	        return "Success !!";
	    }

}
