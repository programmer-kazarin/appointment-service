package com.kazarin.appointment.dto;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Builder
@Data
public class ErrorDto {
    private OffsetDateTime time;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
