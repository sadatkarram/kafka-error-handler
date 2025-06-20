package com.example.kafka_error_handler.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AgentRewardProducer {

    @Value("${agent.dashboard.topic}")
    private String topicName;

    private final KafkaTemplate<String, Map<String,Object>> kafkaTemplate;


    public AgentRewardProducer(KafkaTemplate<String, Map<String, Object>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(Map<String, Object> message){
        kafkaTemplate.send(topicName,message);
        System.out.println("Message Published on topic :"+topicName);
    }

}
