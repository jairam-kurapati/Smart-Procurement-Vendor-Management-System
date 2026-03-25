package com.mywaysai.smartprocurementvendormanagementsystem.dto;

import lombok.Data;
@Data
public class VendorDocumentRequest {

        private Long vendorId;
        private String documentType;
        private String documentNumber;

}
