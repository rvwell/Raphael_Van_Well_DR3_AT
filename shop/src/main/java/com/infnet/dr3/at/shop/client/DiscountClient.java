package com.infnet.dr3.at.shop.client;

import com.infnet.dr3.at.shop.domain.dto.DiscountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "discount-service", url = "${discount.service.url:http://discount-service:8082}")
public interface DiscountClient {

    @GetMapping("/discount/current")
    DiscountDTO getDiscount();
}
