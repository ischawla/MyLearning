package com.example.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.rabbitmq.client.AMQP.Exchange;
import com.rabbitmq.client.ConnectionFactory;

@AutoConfiguration
public class MessagingConfig {

	public static String QUEUE_NAME = "ISC_QUEUE";
	public static String EXCHANGE_NAME= "ISC_EXCHANGE";
	public static String ROUTING_KEY = "ISC_ROUTING_KEY";
	
@Bean			
	public Queue queue() {
		return new Queue(QUEUE_NAME);
	}
	@Bean	
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
	
	@Bean
	public Binding binding(Queue queue ,  TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
		
	}
	
	@Bean
	public MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
    public AmqpTemplate template(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
	
	
	
	
}
