package com.mywaysai.smartprocurementvendormanagementsystem.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorRatingRequest {

    private Long vendorId;
    private int qualityScore;
    private int deliveryScore;
    private int priceScore;
}
