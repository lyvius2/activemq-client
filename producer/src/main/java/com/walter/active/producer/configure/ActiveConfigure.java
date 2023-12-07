package com.walter.active.producer.configure;

import com.walter.active.producer.controller.vo.Product;
import org.springframework.context.annotation.Bean;
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
		typeIdMappings.put("product", Product.class);
		messageConverter.setTypeIdMappings(typeIdMappings);
		return messageConverter;
	}
}
