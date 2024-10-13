package com.kazarin.appointment.utils;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.dto.RoleModelDto;
import com.kazarin.appointment.entity.EmployeeEntity;
import com.kazarin.appointment.entity.RoleModelEntity;

public class EntityToDto {

    private EntityToDto() {
    }

    public static RoleModelDto convertRole(RoleModelEntity role) {
        return RoleModelDto.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public static EmployeeDto convertEmployee(EmployeeEntity employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .fio(employee.getFio())
                .role(employee.getRole().getName())
                .build();
    }
}
