package com.kazarin.appointment.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Async
    @Override
    public void notifyEmployeeAccountCreated(Long employeeId, String login, String password) {
        log.info("NOTIFICATION STUB to employee id={}, login='{}', password='{}'", employeeId, login, password);
    }
}
