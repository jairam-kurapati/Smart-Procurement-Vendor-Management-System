package com.mywaysai.smartprocurementvendormanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PaymentRequest {

    private Long invoiceId;
    private double paidAmount;
    private LocalDate paymentDate;
    private String paymentMode;
    private String status;
}