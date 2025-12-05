package com.infnet.dr3.at.discount.controller;

import com.infnet.dr3.at.discount.model.Discount;
import com.infnet.dr3.at.discount.service.DiscountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
@AllArgsConstructor
public class DiscountController {

    private final DiscountService service;

    @GetMapping("/current")
    public Discount getCurrentDiscount(){
        return new Discount(service.getDiscount());
    }

}
