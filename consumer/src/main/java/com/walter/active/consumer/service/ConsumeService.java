package com.walter.active.consumer.service;

import com.walter.active.consumer.controller.vo.ProductV1;
import com.walter.active.consumer.entity.Product;
import com.walter.active.consumer.mapper.ProductMapper;
import com.walter.active.consumer.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ConsumeService {
	private final ProductRepository productRepository;

	public ConsumeService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void accept(ProductV1 productV1) {
		final Product product = ProductMapper.INSTANCE.toEntity(productV1);
		productRepository.save(product);
	}

	public List<ProductV1> getProducts() {
		final List<Product> products = productRepository.findAll();
		return products.stream().map(ProductMapper.INSTANCE::toDto)
								.collect(toList());
	}
}
