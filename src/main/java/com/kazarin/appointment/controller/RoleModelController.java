package com.kazarin.appointment.controller;

import com.kazarin.appointment.entity.RoleModel;
import com.kazarin.appointment.service.RoleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleModelController {
    @Autowired
    private RoleModelService roleModelService;

    @GetMapping("/roles")
    List<RoleModel> findAll() {
        return roleModelService.findAll();
    }
}
