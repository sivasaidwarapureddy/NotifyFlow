package com.notifyflow.email.consumer;

import com.notifyflow.email.event.NotificationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationConsumer {

    @KafkaListener(topics = "email-notifications", groupId = "email-worker-group"

    )

    public void consume(NotificationEvent event) {
if (event.getRecipient().startsWith("fail")) {
    System.out.println("Simulating email delivery failure...");
    throw new RuntimeException("Email delivery failed");
}

        System.out.println("========== EMAIL NOTIFICATION ==========");
        System.out.println("Event ID : " + event.getEventId());
        System.out.println("To       : " + event.getRecipient());
        System.out.println("Message  : " + event.getMessage());
        System.out.println("Created  : " + event.getCreatedAt());
        System.out.println("========================================");
    }
}