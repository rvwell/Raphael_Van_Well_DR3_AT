package com.infnet.dr3.at.shop.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.infnet.dr3.at.shop.client")
public class FeignConfig {
}

