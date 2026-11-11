
package com.notifyflow.api.service;

import com.notifyflow.api.dto.NotificationRequest;
import com.notifyflow.api.dto.NotificationResponse;
import com.notifyflow.api.event.NotificationEvent;
import com.notifyflow.api.producer.NotificationProducer;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    public NotificationResponse createNotification(NotificationRequest request) {

        // Create an event from the incoming request
        NotificationEvent event = new NotificationEvent(
                request.getType(),
                request.getRecipient(),
                request.getMessage()
        );

        // Publish event to Kafka
        notificationProducer.sendNotification(event);

        // Return API response
        return new NotificationResponse(
                "Notification request accepted",
                request.getType(),
                request.getRecipient(),
                "ACCEPTED"
        );
    }
}
