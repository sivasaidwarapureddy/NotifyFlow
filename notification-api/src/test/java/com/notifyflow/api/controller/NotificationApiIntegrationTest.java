
package com.notifyflow.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NotificationApiIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void validEmailRequest_returns202() throws Exception {
        String requestJson = """
                {
                    "type": "EMAIL",
                    "recipient": "siva@example.com",
                    "message": "Your order has been shipped."
                }
                """;

        mockMvc.perform(post("/api/v1/notifications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isAccepted());
    }

    @Test
    void invalidNotificationType_returns400() throws Exception {
        String requestJson = """
                {
                    "type": "FAX",
                    "recipient": "siva@example.com",
                    "message": "Test notification"
                }
                """;

        mockMvc.perform(post("/api/v1/notifications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void malformedJson_returns400() throws Exception {
        mockMvc.perform(post("/api/v1/notifications")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ invalid json }"))
                .andExpect(status().isBadRequest());
    }
}

