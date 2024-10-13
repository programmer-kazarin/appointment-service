package com.kazarin.appointment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("fio")
    private String fio;
    @JsonProperty("role")
    private String role;
}