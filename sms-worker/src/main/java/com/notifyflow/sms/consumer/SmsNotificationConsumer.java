package com.notifyflow.sms.consumer;

import com.notifyflow.sms.event.NotificationEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationConsumer {

    @KafkaListener(
        topics = "sms-notifications",
        groupId = "sms-worker-group"
    )
    public void consume(NotificationEvent event) {
        if (event.getRecipient().startsWith("fail")) {
    System.out.println("Simulating SMS delivery failure...");
    throw new RuntimeException("SMS delivery failed");
}

        System.out.println("========== SMS NOTIFICATION ==========");
        System.out.println("Event ID : " + event.getEventId());
        System.out.println("Phone    : " + event.getRecipient());
        System.out.println("Message  : " + event.getMessage());
        System.out.println("Created  : " + event.getCreatedAt());
        System.out.println("======================================");
    }
}