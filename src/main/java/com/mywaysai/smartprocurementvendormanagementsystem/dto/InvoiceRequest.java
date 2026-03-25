package com.mywaysai.smartprocurementvendormanagementsystem.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRequest {

    private Long purchaseOrderId;
    private String invoiceNumber;
    private double amount;
}

