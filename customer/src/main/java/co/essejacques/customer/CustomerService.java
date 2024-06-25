package co.essejacques.customer;

import co.essejacques.amqp.RabbitMQMessageProducer;
import co.essejacques.clients.fraud.FraudCheckResponse;
import co.essejacques.clients.fraud.FraudClient;
import co.essejacques.clients.notification.NotificationClient;
import co.essejacques.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class CustomerService {
    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudClient fraudCheckService;
    private final NotificationClient emailService;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

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

       NotificationRequest notification =  NotificationRequest.builder()
                .customerId(customer.getId())
                .message("Welcome " + customer.getFirstName() + " " + customer.getLastName())
                .email(customer.getEmail())
                .build();

        this.emailService.send(notification);

        this.rabbitMQMessageProducer.send(
                "internal.exchange",
                "internal.notification.routing.key",
                notification
        );



        log.info("Registered customer: {}", customer);

    }
}
