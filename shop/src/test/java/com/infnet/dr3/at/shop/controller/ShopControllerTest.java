package com.infnet.dr3.at.shop.controller;

import com.infnet.dr3.at.shop.domain.dto.ProductDTO;
import com.infnet.dr3.at.shop.domain.model.OrderResponse;
import com.infnet.dr3.at.shop.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShopControllerTest {

    @Mock
    private ShopService service;

    @InjectMocks
    private ShopController controller;

    private ProductDTO productDTO;
    private OrderResponse orderResponse;

    @BeforeEach
    void setUp() {
        productDTO = new ProductDTO();
        productDTO.setName("Notebook Gamer");
        productDTO.setPrice(5000.0);

        orderResponse = OrderResponse.builder()
                .productName("Notebook Gamer")
                .originalPrice(5000.0)
                .discountApplied(10)
                .finalPrice(4500.0)
                .build();
    }

    @Test
    void testGetAllProducts() {
        List<ProductDTO> products = Arrays.asList(
                productDTO,
                createProductDTO("Mouse Wireless", 100.0)
        );
        when(service.getAllProducts()).thenReturn(products);

        ResponseEntity<List<ProductDTO>> response = controller.getAllProducts();

        assertEquals(2, response.getBody().size());
    }

    @Test
    void testBuyProduct() {
        when(service.calculateOrder(1L)).thenReturn(orderResponse);

        OrderResponse result = controller.buyProduct(1L);

        assertEquals(4500.0, result.getFinalPrice());
    }

    @Test
    void testBuyProductWithDifferentId() {
        OrderResponse differentOrder = OrderResponse.builder()
                .productName("Mouse Wireless")
                .originalPrice(100.0)
                .discountApplied(10)
                .finalPrice(90.0)
                .build();
        when(service.calculateOrder(2L)).thenReturn(differentOrder);

        OrderResponse result = controller.buyProduct(2L);

        assertEquals("Mouse Wireless", result.getProductName());
    }

    private ProductDTO createProductDTO(String name, Double price) {
        ProductDTO dto = new ProductDTO();
        dto.setName(name);
        dto.setPrice(price);
        return dto;
    }
}

