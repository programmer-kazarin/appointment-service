package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.RoleModelDto;
import com.kazarin.appointment.entity.RoleModelEntity;
import com.kazarin.appointment.repo.RoleModelRepo;
import com.kazarin.appointment.service.impl.RoleModelServiceImpl;
import com.kazarin.appointment.utils.EntityToDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class RoleModelServiceMockTest {
    @Mock
    RoleModelRepo roleModelRepo;
    @InjectMocks
    RoleModelServiceImpl roleModelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest() {
        RoleModelEntity role = new RoleModelEntity(1L, "admin", "description");
        when(roleModelRepo.findAll()).thenReturn(List.of(role));

        Assertions.assertArrayEquals(List.of(RoleModelDto.builder()
                        .id(1l)
                        .name("admin")
                        .description("description")
                        .build()).toArray(),
                roleModelService.findAll().toArray());
    }

    @Test
    void findByName() {
        RoleModelEntity role = new RoleModelEntity(1L, "admin", "description");
        when(roleModelRepo.findByName(any())).thenReturn(role);


        Assertions.assertEquals(role, roleModelService.findByName("admin"));
    }
}