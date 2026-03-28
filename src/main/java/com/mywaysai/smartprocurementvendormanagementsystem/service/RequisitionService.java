package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;

public interface RequisitionService {
    Requisition create(Requisition r);
    List<Requisition> list();

    List<Requisition> findAll();
}
