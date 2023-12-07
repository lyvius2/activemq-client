package com.walter.active.consumer.configure;

import com.walter.active.consumer.controller.vo.ProductV1;
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
		typeIdMappings.put("product", ProductV1.class);
		messageConverter.setTypeIdMappings(typeIdMappings);
		return messageConverter;
	}
}
