package co.essejacques.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FRAUD",
//        url = "${clients.fraud.url}",
        path = "/api/v1/fraud-check")
public interface FraudClient {

    @GetMapping("/{PathVariable}")
    FraudCheckResponse getFraudDetails(@PathVariable("PathVariable") Integer PathVariable);
}