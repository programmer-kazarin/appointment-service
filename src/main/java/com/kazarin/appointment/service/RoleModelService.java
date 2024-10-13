package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.RoleModelDto;
import com.kazarin.appointment.entity.RoleModelEntity;

import java.util.List;

public interface RoleModelService {
    List<RoleModelDto> findAll();

    RoleModelEntity findByName(String role);
}
