package com.example.kafka_error_handler.controller;

import com.example.kafka_error_handler.service.AgentRewardProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MessageController {

    private final AgentRewardProducer producer;

    public MessageController(AgentRewardProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public ResponseEntity<Object> sendMessage(@RequestBody Map<String, Object> request){
        producer.publishMessage(request);
        return ResponseEntity.ok("Message Sent !!");
    }
}
