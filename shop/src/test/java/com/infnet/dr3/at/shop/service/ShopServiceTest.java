package com.infnet.dr3.at.shop.service;

import com.infnet.dr3.at.shop.client.DiscountClient;
import com.infnet.dr3.at.shop.client.ProductClient;
import com.infnet.dr3.at.shop.domain.dto.DiscountDTO;
import com.infnet.dr3.at.shop.domain.dto.ProductDTO;
import com.infnet.dr3.at.shop.domain.model.OrderResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopServiceTest {

    @Mock
    private ProductClient productClient;

    @Mock
    private DiscountClient discountClient;

    @InjectMocks
    private ShopService service;

    private ProductDTO productDTO;
    private DiscountDTO discountDTO;

    @BeforeEach
    void setUp() {
        productDTO = new ProductDTO();
        productDTO.setName("Notebook Gamer");
        productDTO.setPrice(5000.0);

        discountDTO = new DiscountDTO();
        discountDTO.setPercentage(10);
    }

    @Test
    void testGetAllProducts() {
        List<ProductDTO> products = Arrays.asList(
                productDTO,
                createProductDTO("Mouse Wireless", 100.0)
        );
        when(productClient.getAllProducts()).thenReturn(products);

        List<ProductDTO> result = service.getAllProducts();

        assertEquals(2, result.size());
    }

    @Test
    void testCalculateOrder() {
        when(productClient.getProductById(1L)).thenReturn(productDTO);
        when(discountClient.getDiscount()).thenReturn(discountDTO);

        OrderResponse result = service.calculateOrder(1L);

        assertEquals("Notebook Gamer", result.getProductName());
    }

    @Test
    void testCalculateOrderWithZeroDiscount() {
        DiscountDTO zeroDiscount = new DiscountDTO();
        zeroDiscount.setPercentage(0);
        when(productClient.getProductById(1L)).thenReturn(productDTO);
        when(discountClient.getDiscount()).thenReturn(zeroDiscount);

        OrderResponse result = service.calculateOrder(1L);

        assertEquals(5000.0, result.getFinalPrice());
    }

    @Test
    void testCalculateOrderWithFullDiscount() {
        DiscountDTO fullDiscount = new DiscountDTO();
        fullDiscount.setPercentage(100);
        when(productClient.getProductById(1L)).thenReturn(productDTO);
        when(discountClient.getDiscount()).thenReturn(fullDiscount);

        OrderResponse result = service.calculateOrder(1L);

        assertEquals(0.0, result.getFinalPrice());
    }

    @Test
    void testCalculateOrderWithDifferentProduct() {
        ProductDTO differentProduct = createProductDTO("Mouse Wireless", 100.0);
        when(productClient.getProductById(2L)).thenReturn(differentProduct);
        when(discountClient.getDiscount()).thenReturn(discountDTO);

        OrderResponse result = service.calculateOrder(2L);

        assertEquals(90.0, result.getFinalPrice());
    }

    @Test
    void testCalculateOrderWithCustomDiscount() {
        DiscountDTO customDiscount = new DiscountDTO();
        customDiscount.setPercentage(25);
        when(productClient.getProductById(1L)).thenReturn(productDTO);
        when(discountClient.getDiscount()).thenReturn(customDiscount);

        OrderResponse result = service.calculateOrder(1L);

        assertEquals(3750.0, result.getFinalPrice());
    }

    private ProductDTO createProductDTO(String name, Double price) {
        ProductDTO dto = new ProductDTO();
        dto.setName(name);
        dto.setPrice(price);
        return dto;
    }
}

