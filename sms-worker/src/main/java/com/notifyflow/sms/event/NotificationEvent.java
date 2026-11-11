package com.notifyflow.sms.event;

import java.time.LocalDateTime;

public class NotificationEvent {

    private String eventId;
    private String type;
    private String recipient;
    private String message;
    private LocalDateTime createdAt;

    public NotificationEvent() {
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