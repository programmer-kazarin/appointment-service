package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.RoleModelDto;
import com.kazarin.appointment.entity.RoleModel;
import com.kazarin.appointment.repo.RoleModelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class RoleModelServiceTest {
    @Autowired
    RoleModelRepo roleModelRepo;
    @Autowired
    RoleModelService roleModelService;

    @BeforeEach
    public void clearDb() {
        roleModelRepo.deleteAll();
    }

    @Test
    public void findAllTest_empty() {
        List<RoleModelDto> actual = roleModelService.findAll();
        Assertions.assertEquals(0, actual.size());
    }

    @Test
    public void findAllTest_full() {
        roleModelRepo.saveAll(List.of(
                RoleModel.builder().name("test1").description("test1").build(),
                RoleModel.builder().name("test2").description("test2").build()));
        List<RoleModelDto> actual = roleModelService.findAll();
        Assertions.assertEquals(2, actual.size());
    }
}