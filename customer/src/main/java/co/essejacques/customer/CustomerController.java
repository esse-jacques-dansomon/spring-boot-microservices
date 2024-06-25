package co.essejacques.customer;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/customers")
@Tag(name = "customers", description = "customers API")
public class CustomerController{

    private final CustomerService customerService;
    @PostMapping
    public void register(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("Registering customer: {}", customerRequest);
        customerService.register(customerRequest);
    }
}
