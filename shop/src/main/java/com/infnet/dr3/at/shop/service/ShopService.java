package com.infnet.dr3.at.shop.service;

import com.infnet.dr3.at.shop.client.DiscountClient;
import com.infnet.dr3.at.shop.client.ProductClient;
import com.infnet.dr3.at.shop.domain.model.OrderResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShopService {

    private final ProductClient productClient;
    private final DiscountClient discountClient;

    public OrderResponse calculateOrder(Long productId) {

        var product = productClient.getProductById(productId);

        var discount = discountClient.getDiscount();

        double finalPrice = product.getPrice() - (product.getPrice() * discount.getPercentage() / 100);

        return OrderResponse.builder()
                .productName(product.getName())
                .originalPrice(product.getPrice())
                .discountApplied(discount.getPercentage())
                .finalPrice(finalPrice)
                .build();
    }
}
