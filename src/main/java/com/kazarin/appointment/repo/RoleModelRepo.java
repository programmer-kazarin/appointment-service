package com.kazarin.appointment.repo;

import com.kazarin.appointment.entity.RoleModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleModelRepo extends JpaRepository<RoleModelEntity, Long> {

    RoleModelEntity findByName(String roleName);
}
