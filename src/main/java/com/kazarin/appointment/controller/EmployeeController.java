package com.kazarin.appointment.controller;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);
        return employeeDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/employees")
    public EmployeeDto createBranch(@RequestBody EmployeeDto employee) {
        return employeeService.createEmployee(employee);
    }
}
