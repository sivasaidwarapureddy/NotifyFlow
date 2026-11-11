
package com.notifyflow.api.dto;

public class NotificationResponse {

    private String message;
    private String type;
    private String recipient;
    private String status;

    public NotificationResponse() {
    }

    public NotificationResponse(
            String message,
            String type,
            String recipient,
            String status) {
        this.message = message;
        this.type = type;
        this.recipient = recipient;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getStatus() {
        return status;
    }
}
