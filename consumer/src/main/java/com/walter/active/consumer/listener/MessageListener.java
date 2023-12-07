package com.walter.active.consumer.listener;

import com.walter.active.consumer.controller.vo.ProductV1;
import com.walter.active.consumer.service.ConsumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {
	private final ConsumeService consumeService;

	public MessageListener(ConsumeService consumeService) {
		this.consumeService = consumeService;
	}

	@JmsListener(destination = "equipment.console.info")
	public void onMessage(ProductV1 productV1) {
		log.info("[Received] payload : {}", productV1.toString());
		consumeService.accept(productV1);
	}
}
