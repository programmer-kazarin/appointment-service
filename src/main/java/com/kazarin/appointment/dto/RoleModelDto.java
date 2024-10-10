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
public class RoleModelDto {
    @JsonProperty("roleId")
    private Long id;
    @JsonProperty("roleName")
    private String name;
    @JsonProperty("roleDescription")
    private String description;
}
