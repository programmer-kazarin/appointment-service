package com.kazarin.appointment.service.impl;

import com.kazarin.appointment.integration.employeeinfo.EmployeeKafkaProducerService;
import com.kazarin.appointment.service.NotificationService;
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
    public void notifyEmployeeAccountCreated(Long employeeId, String login, String password) {
        log.info("NOTIFICATION STUB to employee id={}, login='{}', password='{}'", employeeId, login, password);
        if (integrationEmployeeEnabled) {
            employeeKafkaProducerService.sendMessage(
                    String.format("New employee created: id = %d; , login='%s', password='%s'",
                            employeeId, login, password));
        }
    }
}
