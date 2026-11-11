package com.notifyflow.api.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationEvent {

    private String eventId;
    private String type;
    private String recipient;
    private String message;
    private LocalDateTime createdAt;

    public NotificationEvent() {
    }

    public NotificationEvent(String type, String recipient, String message) {
        this.eventId = UUID.randomUUID().toString();
        this.type = type;
        this.recipient = recipient;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public String getEventId() {
        return eventId;
    }

    public String getType() {
        return type;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}