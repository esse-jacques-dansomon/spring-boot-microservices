package co.essejacques.customer;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Log4j2
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void register(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);

        // todo: check if customer already exists
        // todo: check is email is valid
        FraudCheckResponse fraudCheckResponse = this.restTemplate.getForObject(
                "http://FRAUD/api/fraud-check/{customerId}"
                , FraudCheckResponse.class, customer.getId());
        // todo: send email
        if (fraudCheckResponse.isFraudulent()) {
            throw new IllegalStateException("Fraud detected for customer " + customer.getId());
        }

    }
}
