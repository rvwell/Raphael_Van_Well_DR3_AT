package com.infnet.dr3.at.shop.client;

import com.infnet.dr3.at.shop.domain.dto.DiscountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "discount-service", url = "http://localhost:8082")
public interface DiscountClient {

    @GetMapping("/discounts/current")
    DiscountDTO getDiscount();
}
