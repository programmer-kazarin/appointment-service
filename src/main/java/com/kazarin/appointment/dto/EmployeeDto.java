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
    @JsonProperty(value = "fio", required = true)
    private String fio;
    @JsonProperty(value = "role", required = true)
    private String role;
    @JsonProperty(value = "login", required = true)
    private String login;
}
