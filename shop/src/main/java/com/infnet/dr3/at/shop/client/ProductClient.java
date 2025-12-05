package com.infnet.dr3.at.shop.client;

import com.infnet.dr3.at.shop.domain.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "${product.service.url:http://product-service:8081}")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductDTO> getAllProducts();

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable Long id);
}
