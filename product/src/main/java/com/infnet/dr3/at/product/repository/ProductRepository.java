package com.infnet.dr3.at.product.repository;

import com.infnet.dr3.at.product.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
