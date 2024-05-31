package co.essejacques.notification;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest customer) {
        log.info("Sending notification to customer: {}", customer);
         notificationRepository.save(
                Notification.builder()
                        .toCustomerId(customer.getCustomerId())
                        .toCustomerEmail(customer.getEmail())
                        .message(customer.getMessage())
                        .sender("essejacques.co")
                        .sentAt(java.time.LocalDateTime.now())
                        .build()
        );
    }
}
