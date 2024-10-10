package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.RoleModelDto;

import java.util.List;

public interface RoleModelService {
    List<RoleModelDto> findAll();
}
