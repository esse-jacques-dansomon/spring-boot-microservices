package com.essejacques.app.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATION", path = "/api/v1/notification")
public interface NotificationClient {

        @PostMapping("/")
        void send(@RequestBody NotificationRequest notification);
}
