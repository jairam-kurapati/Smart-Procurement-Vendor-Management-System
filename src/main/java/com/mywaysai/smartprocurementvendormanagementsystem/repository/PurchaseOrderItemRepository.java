package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrderItem;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;

public interface PurchaseOrderItemRepository extends JpaRepository< PurchaseOrderItem,Long>{ 
} 