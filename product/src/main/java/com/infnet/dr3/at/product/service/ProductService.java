package com.infnet.dr3.at.product.service;

import com.infnet.dr3.at.product.domain.model.Product;
import com.infnet.dr3.at.product.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @PostConstruct
    public void initData() {
        repository.saveAll(List.of(
                new Product(null, "Notebook Gamer", 5000.0),
                new Product(null, "Mouse Wireless", 100.0)
        ));
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
