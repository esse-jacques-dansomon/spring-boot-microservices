package co.essejacques.notification;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

        private final NotificationService notificationService;

        @PostMapping(path = "/")
        public void send(NotificationRequest notificationRequest) {
                 notificationService.send(notificationRequest);
        }
}
