package com.kazarin.appointment.service.impl;

import com.kazarin.appointment.dto.RoleModelDto;
import com.kazarin.appointment.repo.RoleModelRepo;
import com.kazarin.appointment.service.RoleModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class RoleModelServiceImpl implements RoleModelService {
    @Autowired
    private RoleModelRepo roleModelRepo;

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public List<RoleModelDto> findAll() {
        log.debug("getting all roles");
        return roleModelRepo.findAll().stream()
                .map(role -> RoleModelDto.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .description(role.getDescription())
                        .build()).toList();
    }
}
