package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.RoleModelDto;
import com.kazarin.appointment.entity.RoleModelEntity;
import com.kazarin.appointment.repo.RoleModelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RoleModelServiceTest extends AbstractIntegrationTest {
    @Autowired
    RoleModelRepo roleModelRepo;
    @Autowired
    RoleModelService roleModelService;

    @Test
    public void findAllTest_empty() {
        List<RoleModelDto> actual = roleModelService.findAll();
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void findAllTest_full() {
        roleModelRepo.saveAll(List.of(
                RoleModelEntity.builder().name("test1").description("test1").build(),
                RoleModelEntity.builder().name("test2").description("test2").build()));
        List<RoleModelDto> actual = roleModelService.findAll();
        Assertions.assertEquals(2, actual.size());
    }
}