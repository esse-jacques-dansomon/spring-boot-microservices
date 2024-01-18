package co.essejacques.notification;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/notification")
@Log4j2
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping(path = "/")
    public void send(NotificationRequest notificationRequest) {
        log.info("Sending notification: {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
