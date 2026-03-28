package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;


public interface PurchaseOrderRepository  extends JpaRepository<PurchaseOrder,Long>{ 
}