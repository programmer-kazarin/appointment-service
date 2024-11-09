package com.kazarin.appointment.service.impl;

import com.kazarin.appointment.dto.EmployeeDto;
import com.kazarin.appointment.dto.EmployeeMobileDto;
import com.kazarin.appointment.entity.EmployeeEntity;
import com.kazarin.appointment.exceptions.AppointmentEntityNotFoundException;
import com.kazarin.appointment.repo.EmployeeRepo;
import com.kazarin.appointment.service.EmployeeService;
import com.kazarin.appointment.service.NotificationService;
import com.kazarin.appointment.service.RoleModelService;
import com.kazarin.appointment.utils.EntityToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.kazarin.appointment.utils.EntityToDto.convertEmployee;
import static com.kazarin.appointment.utils.PasswordGenerator.encodePassword;
import static com.kazarin.appointment.utils.PasswordGenerator.generatePassword;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private RoleModelService roleModelService;
    @Autowired
    private NotificationService notificationService;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<EmployeeDto> findAll() {
        return employeeRepo.findAll().stream()
                .map(EntityToDto::convertEmployee)
                .toList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Optional<EmployeeDto> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepo.findById(id);
        return employee.map(EntityToDto::convertEmployee);
    }

    @Override
    public Optional<EmployeeMobileDto> getEmployeeByIdForMobile(Long id) {
        Optional<EmployeeEntity> employee = employeeRepo.findById(id);
        return employee.map(EntityToDto::convertEmployeeForMobile);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        String rawPassword = generatePassword();
        EmployeeEntity newEmployee = EmployeeEntity.builder()
                .fio(employee.getFio())
                .role(roleModelService.findByName(employee.getRole()))
                .login(employee.getLogin())
                .password(encodePassword(rawPassword))
                .build();
        EmployeeEntity saved = employeeRepo.save(newEmployee);
        notificationService.notifyEmployeeAccountCreated(saved.getFio(), saved.getLogin(), saved.getRole().getName());
        return convertEmployee(saved);
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(EmployeeDto employee) {
        EmployeeEntity employeeFromDb = employeeRepo.findById(employee.getId())
                .orElseThrow(() ->
                        new AppointmentEntityNotFoundException(
                                "Employee with id = " + employee.getId() + " not found"));
        employeeFromDb.setFio(employee.getFio());
        employeeFromDb.setRole(roleModelService.findByName(employee.getRole()));
        return convertEmployee(employeeFromDb);
    }
}
