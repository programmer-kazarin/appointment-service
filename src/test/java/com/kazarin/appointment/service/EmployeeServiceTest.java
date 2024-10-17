package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest extends AbstractIntegrationTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void findAllTest() {
        List<EmployeeDto> actual = employeeService.findAll();
        assertEquals(0, actual.size());
    }

    @Test
    void findByIdTest_empty() {
        Optional<EmployeeDto> actual = employeeService.getEmployeeById(9L);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    void createEmployeeTest() {
        initAdmin();
        EmployeeDto actual = employeeService.createEmployee(EmployeeDto.builder().fio("TEST").role("admin").build());
        assertNotNull(actual);
    }
}