package com.walter.active.producer.controller.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Product implements Serializable {
	@Schema(description = "콘솔", example = "Play Station 4")
	private String consoleName;

	@Schema(description = "제조사", example = "SONY")
	private String manufacturer;
}
