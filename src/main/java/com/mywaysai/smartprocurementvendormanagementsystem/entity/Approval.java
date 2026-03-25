package com.mywaysai.smartprocurementvendormanagementsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String managerName;
    private String decision;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime approvedDate;

    @OneToOne
    private Requisition requisition;
}

