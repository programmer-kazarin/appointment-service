package com.kazarin.appointment.service.impl;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.entity.EmployeeEntity;
import com.kazarin.appointment.repo.EmployeeRepo;
import com.kazarin.appointment.service.EmployeeService;
import com.kazarin.appointment.service.RoleModelService;
import com.kazarin.appointment.utils.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.kazarin.appointment.utils.EntityToDto.convertEmployee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private RoleModelService roleModelService;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<EmployeeDto> findAll() {
        return employeeRepo.findAll().stream()
                .map(EntityToDto::convertEmployee)
                .toList();
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepo.findById(id);
        return employee.map(EntityToDto::convertEmployee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        EmployeeEntity newEmployee = EmployeeEntity.builder()
                .fio(employee.getFio())
                .role(roleModelService.findByName(employee.getRole()))
                .build();
        EmployeeEntity saved = employeeRepo.save(newEmployee);
        return convertEmployee(saved);
    }
}