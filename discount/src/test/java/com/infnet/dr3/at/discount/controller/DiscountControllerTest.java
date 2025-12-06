package com.infnet.dr3.at.discount.controller;

import com.infnet.dr3.at.discount.model.Discount;
import com.infnet.dr3.at.discount.service.DiscountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DiscountControllerTest {

    @Mock
    private DiscountService service;

    @InjectMocks
    private DiscountController controller;

    @Test
    void testGetCurrentDiscount() {
        int expectedDiscount = 10;
        when(service.getDiscount()).thenReturn(expectedDiscount);

        Discount result = controller.getCurrentDiscount();

        assertEquals(expectedDiscount, result.getPercentage());
    }

    @Test
    void testGetCurrentDiscountWithDifferentValue() {
        int expectedDiscount = 15;
        when(service.getDiscount()).thenReturn(expectedDiscount);

        Discount result = controller.getCurrentDiscount();

        assertEquals(expectedDiscount, result.getPercentage());
    }
}

