package com.example.kafka_error_handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;

@SpringBootApplication
public class KafkaErrorHandlerApplication {

    public static void main(String[] args) {

		SpringApplication.run(KafkaErrorHandlerApplication.class, args);
    }

}
