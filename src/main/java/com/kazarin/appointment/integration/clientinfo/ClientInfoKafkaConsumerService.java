package com.kazarin.appointment.integration.clientinfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClientInfoKafkaConsumerService {
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    @Value("${integration.client-info.topic}")
    private String topic;

    @KafkaListener(topics = "client-event", groupId = "appointment-group")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
