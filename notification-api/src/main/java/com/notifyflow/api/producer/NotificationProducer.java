
package com.notifyflow.api.producer;

import com.notifyflow.api.event.NotificationEvent;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationProducer {

    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    public NotificationProducer(
            KafkaTemplate<String, NotificationEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendNotification(NotificationEvent event) {

        String topic;

        if ("EMAIL".equals(event.getType())) {
            topic = "email-notifications";
        } else {
            topic = "sms-notifications";
        }

        kafkaTemplate.send(topic, event.getEventId(), event);
    }
}
