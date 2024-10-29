package com.kazarin.appointment.integration.employeekafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaProducerService {
    @Value("${integration.employee.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> employeeKafkaTemplate;

    public void sendMessage(String message) {
        employeeKafkaTemplate.send(topic, message);
    }
}
