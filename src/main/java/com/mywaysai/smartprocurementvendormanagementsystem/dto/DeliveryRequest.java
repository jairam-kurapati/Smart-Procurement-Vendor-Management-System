package com.mywaysai.smartprocurementvendormanagementsystem.dto;

import lombok.Data;
@Data
public class DeliveryRequest {

        private Long purchaseOrderId;
        private String trackingNumber;
        private String deliveryStatus;
    }

