package com.infnet.dr3.at.shop.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
    private String productName;
    private Double originalPrice;
    private int discountApplied;
    private Double finalPrice;
}
