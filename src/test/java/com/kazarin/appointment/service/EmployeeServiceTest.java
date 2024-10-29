package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.exceptions.AppointmentEntityNotFoundException;
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
    public void findAllTest() {
        List<EmployeeDto> actual = employeeService.findAll();
        assertEquals(0, actual.size());
    }

    @Test
    public void findByIdTest_empty() {
        Optional<EmployeeDto> actual = employeeService.getEmployeeById(9L);
        assertEquals(Optional.empty(), actual);
    }

    @Test
    public void createEmployeeTest() {
        initAdminRole();
        EmployeeDto actual = employeeService.createEmployee(EmployeeDto.builder().fio("TEST").role("admin").login("test_login").build());
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals("TEST", actual.getFio());
        assertEquals("admin", actual.getRole());
        assertEquals("test_login", actual.getLogin());
    }

    @Test
    public void updateEmployeeTest() {
        initAdminRole();
        EmployeeDto created = employeeService.createEmployee(EmployeeDto.builder().fio("TEST").role("admin").build());
        created.setFio("NEW_TEST");
        employeeService.updateEmployee(created);

        EmployeeDto actual = employeeService.getEmployeeById(created.getId()).get();
        assertEquals("NEW_TEST", actual.getFio());
    }

    @Test
    public void updateEmployeeTest_not_found() {
        initAdminRole();
        EmployeeDto created = EmployeeDto.builder().id(99L).fio("NEW_TEST").role("admin").build();
        assertThrows(AppointmentEntityNotFoundException.class, () -> employeeService.updateEmployee(created));
    }
}