package com.kazarin.appointment.service.impl;

public interface NotificationService {
    void notifyEmployeeAccountCreated(Long employeeId, String login, String password);
}
