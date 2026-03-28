//package com.mywaysai.smartprocurementvendormanagementsystem.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Getter @Setter
//public class Payment {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private double paidAmount;
//    private String paymentStatus;
//
//    @OneToOne
//    private Invoice invoice;
//
//
//
//
//}


package com.mywaysai.smartprocurementvendormanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double paidAmount;

    private LocalDate paymentDate;

    private String paymentMode;

    private String status;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}