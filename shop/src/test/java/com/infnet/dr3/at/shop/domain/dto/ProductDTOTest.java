package com.infnet.dr3.at.shop.domain.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDTOTest {

    @Test
    void testProductDTOSetterAndGetter() {
        ProductDTO dto = new ProductDTO();

        dto.setName("Notebook Gamer");
        dto.setPrice(5000.0);

        assertEquals(5000.0, dto.getPrice());
    }

    @Test
    void testProductDTOEquals() {
        ProductDTO dto1 = new ProductDTO();
        dto1.setName("Notebook Gamer");
        dto1.setPrice(5000.0);

        ProductDTO dto2 = new ProductDTO();
        dto2.setName("Notebook Gamer");
        dto2.setPrice(5000.0);

        ProductDTO dto3 = new ProductDTO();
        dto3.setName("Mouse Wireless");
        dto3.setPrice(100.0);

        assertEquals(dto1, dto2);
    }

    @Test
    void testProductDTOHashCode() {
        ProductDTO dto1 = new ProductDTO();
        dto1.setName("Notebook Gamer");
        dto1.setPrice(5000.0);

        ProductDTO dto2 = new ProductDTO();
        dto2.setName("Notebook Gamer");
        dto2.setPrice(5000.0);

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testProductDTOToString() {
        ProductDTO dto = new ProductDTO();
        dto.setName("Notebook Gamer");
        dto.setPrice(5000.0);

        String result = dto.toString();

        assertTrue(result.contains("Notebook Gamer"));
    }
}

