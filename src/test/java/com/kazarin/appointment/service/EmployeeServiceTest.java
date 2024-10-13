package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.entity.RoleModelEntity;
import com.kazarin.appointment.repo.EmployeeRepo;
import com.kazarin.appointment.repo.RoleModelRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleModelRepo roleModelRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @BeforeEach
    public void prepareDb() {
        employeeRepo.deleteAll();
        roleModelRepo.deleteAll();
        roleModelRepo.saveAll(List.of(
                RoleModelEntity.builder().name("admin").description("test1").build()));
    }

    @Test
    void findAllTest() {
        List<EmployeeDto> actual = employeeService.findAll();
        assertEquals(0, actual.size());
    }

    @Test
    void findByIdTest() {
        Optional<EmployeeDto> actual = employeeService.getEmployeeById(9L);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    void createEmployeeTest() {
        EmployeeDto actual = employeeService.createEmployee(EmployeeDto.builder().fio("TEST").role("admin").build());
        assertNotNull(actual);
    }
}