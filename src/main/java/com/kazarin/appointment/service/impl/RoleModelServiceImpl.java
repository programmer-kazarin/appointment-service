package com.kazarin.appointment.service.impl;

import com.kazarin.appointment.entity.RoleModel;
import com.kazarin.appointment.repo.RoleModelRepo;
import com.kazarin.appointment.service.RoleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleModelServiceImpl implements RoleModelService {
    @Autowired
    private RoleModelRepo roleModelRepo;

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public List<RoleModel> findAll() {
        return roleModelRepo.findAll();
    }
}
