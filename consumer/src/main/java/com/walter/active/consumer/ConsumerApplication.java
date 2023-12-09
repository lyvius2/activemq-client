package com.walter.active.consumer;

import com.walter.active.consumer.controller.vo.StatusV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Bean
	public StatusV1 status() {
		return new StatusV1();
	}

}
