package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;

public interface VendorService {
    Vendor register(Vendor vendor);
    List<Vendor> getAll();

    Vendor approveVendor(Long id);
}

