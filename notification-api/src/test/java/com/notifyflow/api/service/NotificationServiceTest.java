
package com.notifyflow.api.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.notifyflow.api.dto.NotificationRequest;
import com.notifyflow.api.dto.NotificationResponse;
import com.notifyflow.api.event.NotificationEvent;
import com.notifyflow.api.producer.NotificationProducer;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private NotificationProducer notificationProducer;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void createNotification_withValidEmail_returnsAcceptedResponse() {

        // Arrange
        NotificationRequest request = new NotificationRequest();
        request.setType("EMAIL");
        request.setRecipient("siva@example.com");
        request.setMessage("Your order has been shipped.");

        // Act
        NotificationResponse response =
                notificationService.createNotification(request);

        // Assert
        assertNotNull(response);
        assertEquals("Notification request accepted", response.getMessage());
        assertEquals("EMAIL", response.getType());
        assertEquals("siva@example.com", response.getRecipient());
        assertEquals("ACCEPTED", response.getStatus());

        verify(notificationProducer, times(1))
                .sendNotification(any(NotificationEvent.class));
    }
}
