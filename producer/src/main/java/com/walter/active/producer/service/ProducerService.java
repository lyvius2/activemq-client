package com.walter.active.producer.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	private final JmsTemplate jmsTemplate;

	public ProducerService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendToQueue(String queueName, Object object) {
		jmsTemplate.convertAndSend(queueName, object);
	}
}
