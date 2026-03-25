package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorDocument;

import java.util.List;

public interface VendorDocumentService {
    VendorDocument upload(VendorDocument doc);

    VendorDocument save(Long vendorId, String type, String number);

    List<VendorDocument> getAll();
}
