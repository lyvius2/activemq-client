package com.walter.active.consumer.configure;

import com.walter.active.consumer.controller.vo.ProductV1;
import jakarta.jms.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ActiveConfigure {
	@Bean
	public MappingJackson2MessageConverter messageConverter() {
		final MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
		messageConverter.setTypeIdPropertyName("_typeId");

		final Map<String, Class<?>> typeIdMappings = new HashMap<>();
		typeIdMappings.put("text", String.class);
		typeIdMappings.put("product", ProductV1.class);
		messageConverter.setTypeIdMappings(typeIdMappings);
		return messageConverter;
	}

	@Bean
	public JmsListenerContainerFactory<?> queueConnectionFactory(@Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory,
	                                                             DefaultJmsListenerContainerFactoryConfigurer configurer) {
		final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setPubSubDomain(false);
		return factory;
	}

	@Bean
	public JmsListenerContainerFactory<?> topicConnectionFactory(@Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory,
	                                                             DefaultJmsListenerContainerFactoryConfigurer configurer) {
		final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		factory.setPubSubDomain(true);
		return factory;
	}
}
