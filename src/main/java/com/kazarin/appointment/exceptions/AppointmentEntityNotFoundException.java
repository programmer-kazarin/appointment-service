package com.kazarin.appointment.exceptions;

public class AppointmentEntityNotFoundException extends RuntimeException {
    public AppointmentEntityNotFoundException(String message) {
        super("Entity not found: " + message);
    }
}
