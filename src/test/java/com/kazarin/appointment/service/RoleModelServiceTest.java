package com.kazarin.appointment.service;

import com.kazarin.appointment.entity.RoleModel;
import com.kazarin.appointment.repo.RoleModelRepo;
import com.kazarin.appointment.service.impl.RoleModelServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
class RoleModelServiceTest {
    @MockBean
    RoleModelRepo roleModelRepo;

    @Autowired
    RoleModelService roleModelService;

    @Test
    public void findAllTest() {
        RoleModel role = new RoleModel();
        role.setId(1L);
        role.setName("admin");
        role.setDescription("description");
        when(roleModelRepo.findAll()).thenReturn(List.of(role));
        Assertions.assertArrayEquals(List.of(role).toArray(), roleModelService.findAll().toArray());
    }
}