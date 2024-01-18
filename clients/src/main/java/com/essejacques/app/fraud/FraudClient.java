package com.essejacques.app.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FRAUD", path = "/api/v1/fraud-check")
public interface FraudClient {

    @GetMapping("/{PathVariable}")
    FraudCheckResponse getFraudDetails(@PathVariable("PathVariable") Integer PathVariable);
}