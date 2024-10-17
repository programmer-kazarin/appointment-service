package com.kazarin.appointment.service;

import com.kazarin.appointment.entity.RoleModelEntity;
import com.kazarin.appointment.repo.EmployeeRepo;
import com.kazarin.appointment.repo.RoleModelRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class AbstractIntegrationTest {
    @Autowired
    private RoleModelRepo roleModelRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @BeforeEach
    public void prepareDb() {
        log.debug("BeforeEach start");
        employeeRepo.deleteAll();
        roleModelRepo.deleteAll();
        log.debug("BeforeEach finish");
    }

    protected void initAdmin() {
        roleModelRepo.saveAll(List.of(
                RoleModelEntity.builder().name("admin").description("test1").build()));
    }

}
