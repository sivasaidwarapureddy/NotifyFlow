
package com.notifyflow.api.controller;

import com.notifyflow.api.dto.NotificationRequest;
import com.notifyflow.api.dto.NotificationResponse;
import com.notifyflow.api.service.NotificationService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> createNotification(
            @Valid @RequestBody NotificationRequest request) {

        NotificationResponse response = notificationService.createNotification(request);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }

}
