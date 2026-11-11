package com.notifyflow.api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.notifyflow.api.dto.NotificationRequest;
import com.notifyflow.api.dto.NotificationResponse;
import com.notifyflow.api.service.NotificationService;

public class NotificationControllerTest {

    @Test 
    void testCreateNotification() {
        // Implement test logic for createNotification method
       NotificationService service = mock(NotificationService.class);
       NotificationController controller =
                new NotificationController(service);

        NotificationRequest request = new NotificationRequest();
        request.setType("EMAIL");
        request.setRecipient("siva@example.com");
        request.setMessage("Your order has been shipped.");


        NotificationResponse expected = new NotificationResponse(
                "Notification request accepted",
                "EMAIL",
                "siva@example.com",
                "ACCEPTED"
        );


        when(service.createNotification(request)).thenReturn(expected);

          // Act
        ResponseEntity<NotificationResponse> response =
                controller.createNotification(request);


        // Assert
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(expected, response.getBody());
        verify(service).createNotification(request);
    }
    
}
