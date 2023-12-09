package com.walter.active.producer.service;

import org.apache.activemq.artemis.jms.client.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	private final JmsTemplate jmsTemplate;

	public ProducerService(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendToQueue(String queueName, Object object) {
		jmsTemplate.setPubSubDomain(false);
		jmsTemplate.convertAndSend(queueName, object);
	}

	public void sendToTopic(String topicName, Object object) {
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.convertAndSend(new ActiveMQTopic(topicName), object);
	}
}
