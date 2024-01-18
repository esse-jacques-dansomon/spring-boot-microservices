package co.essejacques.customer;

import com.essejacques.app.fraud.FraudCheckResponse;
import com.essejacques.app.fraud.FraudClient;
import com.essejacques.app.notification.NotificationClient;
import com.essejacques.app.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Log4j2
public class CustomerService {
    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudClient fraudCheckService;
    private final NotificationClient emailService;

    public void register(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        customerRepository.saveAndFlush(customer);

        // todo: check if customer already exists
        // todo: check is email is valid

        FraudCheckResponse fraudCheckResponse = this.fraudCheckService.getFraudDetails(customer.getId());
        // todo: send email
        if (fraudCheckResponse.isFraudulent()) {
            throw new IllegalStateException("Fraud detected for customer " + customer.getId());
        }

        this.emailService.send(
                NotificationRequest.builder()
                        .customerId(customer.getId())
                        .message("Welcome " + customer.getFirstName() + " " + customer.getLastName())
                        .build()
        );

        log.info("Registered customer: {}", customer);

    }
}
