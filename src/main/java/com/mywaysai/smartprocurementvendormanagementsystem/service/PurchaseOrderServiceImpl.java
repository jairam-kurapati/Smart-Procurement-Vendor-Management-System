package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepository;
    private final VendorRepository vendorRepository;

    public PurchaseOrder create(Long vendorId){

        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();

        PurchaseOrder po = new PurchaseOrder();
        po.setPoNumber("PO-" + System.currentTimeMillis());
        po.setStatus("CREATED");
        po.setOrderDate(LocalDate.now());
        po.setVendor(vendor);

        return poRepository.save(po);
    }

    public List<PurchaseOrder> all(){
        return poRepository.findAll();
    }
}
