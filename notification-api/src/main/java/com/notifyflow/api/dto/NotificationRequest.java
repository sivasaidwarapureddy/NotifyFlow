package com.notifyflow.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NotificationRequest {

    @NotBlank(message = "Notification type is required")
    @Pattern(
        regexp = "EMAIL|SMS",
        message = "Type must be EMAIL or SMS"
    )
    private String type;

    @NotBlank(message = "Recipient is required")
    @Size(max = 255, message = "Recipient must not exceed 255 characters")
    private String recipient;


    @NotBlank(message = "Message is required")
    @Size(max = 1000, message = "Message must not exceed 1000 characters")
    private String message;

    public NotificationRequest() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}