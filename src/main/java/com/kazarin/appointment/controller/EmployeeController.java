package com.kazarin.appointment.controller;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.dto.EmployeeMobileDto;
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

    @GetMapping("/ui/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(id);
        return employeeDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/mobile/employees/{id}")
    public ResponseEntity<EmployeeMobileDto> getEmployeeByIdForMobile(@PathVariable Long id) {
        Optional<EmployeeMobileDto> employeeDto = employeeService.getEmployeeByIdForMobile(id);
        return employeeDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @PutMapping("/employees")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }
}
