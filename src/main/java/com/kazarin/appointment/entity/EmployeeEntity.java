package com.kazarin.appointment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio", nullable = false)
    private String fio;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleModelEntity role;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}
