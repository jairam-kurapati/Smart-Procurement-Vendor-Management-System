package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final PurchaseOrderRepository repository;

    public List<PurchaseOrder> spendAnalysis(){
        return repository.findAll();
    }
}
