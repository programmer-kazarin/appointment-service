package com.kazarin.appointment.controller.handler;

import com.kazarin.appointment.dto.ErrorDto;
import com.kazarin.appointment.exceptions.AppointmentEntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.OffsetDateTime;

@ControllerAdvice
public class AppointmentServiceExceptionHandler {
    @ExceptionHandler({AppointmentEntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDto> handleException(AppointmentEntityNotFoundException ex, HttpServletRequest request) {
        return getErrorDtoResponseEntity(ex, request, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorDto> getErrorDtoResponseEntity(Throwable ex,
                                                               HttpServletRequest request,
                                                               HttpStatus status) {
        return new ResponseEntity<>(ErrorDto.builder()
                .time(OffsetDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build(), status);
    }
}
