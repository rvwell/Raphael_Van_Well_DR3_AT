package com.infnet.dr3.at.product.controller;

import com.infnet.dr3.at.product.domain.model.Product;
import com.infnet.dr3.at.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1L, "Notebook Gamer", 5000.0);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(
                product,
                new Product(2L, "Mouse Wireless", 100.0)
        );
        when(service.findAll()).thenReturn(products);

        ResponseEntity<List<Product>> response = controller.getAllProducts();

        assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetProductById() {
        when(service.findById(1L)).thenReturn(product);

        ResponseEntity<Product> response = controller.getProduct(1L);

        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testCreateProduct() {
        Product newProduct = new Product(null, "Teclado Mecânico", 300.0);
        Product savedProduct = new Product(3L, "Teclado Mecânico", 300.0);
        when(service.save(any(Product.class))).thenReturn(savedProduct);

        ResponseEntity<Product> response = controller.createProduct(newProduct);

        assertEquals(3L, response.getBody().getId());
    }

    @Test
    void testUpdateProduct() {
        Product updatedProduct = new Product(1L, "Notebook Gamer Pro", 5500.0);
        when(service.update(eq(1L), any(Product.class))).thenReturn(updatedProduct);

        ResponseEntity<Product> response = controller.updateProduct(1L, updatedProduct);

        assertEquals("Notebook Gamer Pro", response.getBody().getName());
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(service).delete(1L);

        ResponseEntity<Void> response = controller.deleteProduct(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}

