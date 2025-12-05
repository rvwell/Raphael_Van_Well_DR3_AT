package com.infnet.dr3.at.shop.controller;

import com.infnet.dr3.at.shop.domain.dto.ProductDTO;
import com.infnet.dr3.at.shop.domain.model.OrderResponse;
import com.infnet.dr3.at.shop.service.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {

    private final ShopService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = service.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/buy/{productId}")
    public OrderResponse buyProduct(@PathVariable Long productId) {
        return service.calculateOrder(productId);
    }
}
