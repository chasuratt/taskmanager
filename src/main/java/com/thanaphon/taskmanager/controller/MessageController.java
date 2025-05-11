package com.thanaphon.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {

    @GetMapping("/api/message")
    public Map<String, Object> getMessage() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Hello from Simple API!");
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", "success");
        return response;
    }
    
    // Health check endpoint (useful for deployment)
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        return status;
    }
}