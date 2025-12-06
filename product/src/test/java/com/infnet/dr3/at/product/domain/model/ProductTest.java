package com.infnet.dr3.at.product.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductConstructor() {
        Product product = new Product(1L, "Notebook Gamer", 5000.0);

        assertEquals(1L, product.getId());
    }

    @Test
    void testProductNoArgsConstructor() {
        Product product = new Product();

        assertNull(product.getId());
    }

    @Test
    void testProductSettersAndGetters() {
        Product product = new Product();

        product.setId(1L);
        product.setName("Mouse Wireless");
        product.setPrice(100.0);

        assertEquals(100.0, product.getPrice());
    }

    @Test
    void testProductEquals() {
        Product product1 = new Product(1L, "Notebook Gamer", 5000.0);
        Product product2 = new Product(1L, "Notebook Gamer", 5000.0);

        assertEquals(product1, product2);
    }

    @Test
    void testProductHashCode() {
        Product product1 = new Product(1L, "Notebook Gamer", 5000.0);
        Product product2 = new Product(1L, "Notebook Gamer", 5000.0);

        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void testProductToString() {
        Product product = new Product(1L, "Notebook Gamer", 5000.0);

        String result = product.toString();

        assertTrue(result.contains("Notebook Gamer"));
    }
}

