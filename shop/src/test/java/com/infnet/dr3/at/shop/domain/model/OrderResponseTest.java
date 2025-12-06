package com.infnet.dr3.at.shop.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderResponseTest {

    @Test
    void testOrderResponseBuilder() {
        OrderResponse order = OrderResponse.builder()
                .productName("Notebook Gamer")
                .originalPrice(5000.0)
                .discountApplied(10)
                .finalPrice(4500.0)
                .build();

        assertEquals(4500.0, order.getFinalPrice());
    }

    @Test
    void testOrderResponseSettersAndGetters() {
        OrderResponse order = OrderResponse.builder().build();

        order.setProductName("Mouse Wireless");
        order.setOriginalPrice(100.0);
        order.setDiscountApplied(10);
        order.setFinalPrice(90.0);

        assertEquals(90.0, order.getFinalPrice());
    }

    @Test
    void testOrderResponseEquals() {
        OrderResponse order1 = OrderResponse.builder()
                .productName("Notebook Gamer")
                .originalPrice(5000.0)
                .discountApplied(10)
                .finalPrice(4500.0)
                .build();

        OrderResponse order2 = OrderResponse.builder()
                .productName("Notebook Gamer")
                .originalPrice(5000.0)
                .discountApplied(10)
                .finalPrice(4500.0)
                .build();

        assertEquals(order1, order2);
    }

    @Test
    void testOrderResponseHashCode() {
        OrderResponse order1 = OrderResponse.builder()
                .productName("Notebook Gamer")
                .originalPrice(5000.0)
                .discountApplied(10)
                .finalPrice(4500.0)
                .build();

        OrderResponse order2 = OrderResponse.builder()
                .productName("Notebook Gamer")
                .originalPrice(5000.0)
                .discountApplied(10)
                .finalPrice(4500.0)
                .build();

        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    void testOrderResponseToString() {
        OrderResponse order = OrderResponse.builder()
                .productName("Notebook Gamer")
                .originalPrice(5000.0)
                .discountApplied(10)
                .finalPrice(4500.0)
                .build();

        String result = order.toString();

        assertTrue(result.contains("Notebook Gamer"));
    }
}

