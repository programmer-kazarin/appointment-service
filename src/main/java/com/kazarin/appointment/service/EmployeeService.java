package com.kazarin.appointment.service;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.dto.EmployeeMobileDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDto> findAll();

    Optional<EmployeeDto> getEmployeeById(Long id);

    Optional<EmployeeMobileDto> getEmployeeByIdForMobile(Long id);

    EmployeeDto createEmployee(EmployeeDto employee);

    EmployeeDto updateEmployee(EmployeeDto employee);
}
