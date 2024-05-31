package co.essejacques.clients;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud-check")
@AllArgsConstructor
@Log4j2
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
       boolean IsFraudulent =  fraudCheckService.isFraudster(customerId);
         log.info("Fraudulent customer: {}", IsFraudulent);
        return new FraudCheckResponse(IsFraudulent);
    }
}
