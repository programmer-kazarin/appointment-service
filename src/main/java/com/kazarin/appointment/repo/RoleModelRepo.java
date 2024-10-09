package com.kazarin.appointment.repo;

import com.kazarin.appointment.entity.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleModelRepo extends JpaRepository<RoleModel, Long> {

}
