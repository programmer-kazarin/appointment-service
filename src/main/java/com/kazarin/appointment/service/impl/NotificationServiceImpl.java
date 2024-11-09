package com.kazarin.appointment.service.impl;

import com.kazarin.appointment.integration.employeeinfo.EmployeeKafkaProducerService;
import com.kazarin.appointment.service.NotificationService;
import com.kazarin.avro.EmployeeCreatedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Value("${integration.employee-info.enabled}")
    private Boolean integrationEmployeeEnabled;

    @Autowired
    private EmployeeKafkaProducerService employeeKafkaProducerService;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Async
    @Override
    public void notifyEmployeeAccountCreated(String fio, String login, String role) {
        log.info("NOTIFICATION STUB to employee fio={}, login='{}', role='{}'", fio, login, role);
        if (integrationEmployeeEnabled) {
            employeeKafkaProducerService.sendMessage(
                    EmployeeCreatedMessage.newBuilder()
                            .setFio(fio)
                            .setLogin(login)
                            .setRole(role)
                            .build());

        }
    }
}
