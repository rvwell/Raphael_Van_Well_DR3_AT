package com.infnet.dr3.at.shop.domain.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountDTOTest {

    @Test
    void testDiscountDTOSetterAndGetter() {
        DiscountDTO dto = new DiscountDTO();

        dto.setPercentage(10);

        assertEquals(10, dto.getPercentage());
    }

    @Test
    void testDiscountDTOEquals() {
        DiscountDTO dto1 = new DiscountDTO();
        dto1.setPercentage(10);

        DiscountDTO dto2 = new DiscountDTO();
        dto2.setPercentage(10);

        DiscountDTO dto3 = new DiscountDTO();
        dto3.setPercentage(20);

        assertEquals(dto1, dto2);
    }

    @Test
    void testDiscountDTOHashCode() {
        DiscountDTO dto1 = new DiscountDTO();
        dto1.setPercentage(10);

        DiscountDTO dto2 = new DiscountDTO();
        dto2.setPercentage(10);

        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    void testDiscountDTOToString() {
        DiscountDTO dto = new DiscountDTO();
        dto.setPercentage(10);

        String result = dto.toString();

        assertTrue(result.contains("10"));
    }
}

