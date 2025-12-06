package com.infnet.dr3.at.discount.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void testDiscountConstructor() {
        Discount discount = new Discount(10);

        assertEquals(10, discount.getPercentage());
    }

    @Test
    void testDiscountSetterAndGetter() {
        Discount discount = new Discount(10);

        discount.setPercentage(20);

        assertEquals(20, discount.getPercentage());
    }

    @Test
    void testDiscountEquals() {
        Discount discount1 = new Discount(10);
        Discount discount2 = new Discount(10);

        assertEquals(discount1, discount2);
    }

    @Test
    void testDiscountHashCode() {
        Discount discount1 = new Discount(10);
        Discount discount2 = new Discount(10);

        assertEquals(discount1.hashCode(), discount2.hashCode());
    }

    @Test
    void testDiscountToString() {
        Discount discount = new Discount(10);

        String result = discount.toString();

        assertTrue(result.contains("10"));
    }
}

