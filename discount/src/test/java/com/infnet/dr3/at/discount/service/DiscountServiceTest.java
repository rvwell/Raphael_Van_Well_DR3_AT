package com.infnet.dr3.at.discount.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceTest {

    private DiscountService service;

    @BeforeEach
    void setUp() {
        service = new DiscountService();
    }

    @Test
    void testGetDiscount() {
        int result = service.getDiscount();

        assertEquals(10, result);
    }

    @Test
    void testGetDiscountReturnsInteger() {
        int result = service.getDiscount();

        assertTrue(result > 0);
    }
}

