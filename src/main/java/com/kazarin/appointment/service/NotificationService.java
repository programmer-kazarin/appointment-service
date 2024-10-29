package com.kazarin.appointment.service;

public interface NotificationService {
    void notifyEmployeeAccountCreated(Long employeeId, String login, String password);
}
