package com.kazarin.appointment.repo;

import com.kazarin.appointment.entity.CustomerEntity;
import com.kazarin.appointment.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
}
