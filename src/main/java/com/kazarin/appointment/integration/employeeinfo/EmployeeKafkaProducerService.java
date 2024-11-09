package com.kazarin.appointment.integration.employeeinfo;

import com.kazarin.avro.EmployeeCreatedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaProducerService {
    @Value("${integration.employee-info.topic}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, EmployeeCreatedMessage> employeeKafkaTemplate;

    public void sendMessage(EmployeeCreatedMessage message) {
        employeeKafkaTemplate.send(topic, message);
    }
}
