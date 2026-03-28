package com.mywaysai.smartprocurementvendormanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="users1")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    @ManyToOne
    private Role role;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private boolean active;



}

