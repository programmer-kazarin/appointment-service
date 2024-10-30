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
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "mobile", nullable = false, unique = true)
    private String mobile;

    @Column(name = "email")
    private String email;
}
