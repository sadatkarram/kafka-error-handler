package com.example.kafka_error_handler.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AgentRewardConsumer {

    @KafkaListener(topics = "${agent.dashboard.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Map<String, Object>> record) {
        System.out.println("Received Key: " + record.key());
        System.out.println("Received Value: " + record.value());
        Integer score = (Integer) record.value().get("score");
        if ( score < 50) {
            throw new RuntimeException("Score too low, simulating failure...");
        }
    }

    @KafkaListener(topics = "${agent.dashboard.topic}.dlt", groupId = "${spring.kafka.consumer.group-id}")
    public void handleDLT(ConsumerRecord<String, Map<String, Object>> record) {
        System.err.println("🪣 Sent to DLT: " + record.value());
    }
}
