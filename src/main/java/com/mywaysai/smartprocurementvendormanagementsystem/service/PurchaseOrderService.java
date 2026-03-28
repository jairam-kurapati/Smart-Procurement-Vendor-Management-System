package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;

public interface PurchaseOrderService {
    PurchaseOrder create(Long vendorId);
    List<PurchaseOrder> all();
}
