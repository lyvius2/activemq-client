package com.walter.active.consumer.repository;

import com.walter.active.consumer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
