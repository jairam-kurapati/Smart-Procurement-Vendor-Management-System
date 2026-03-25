package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Inventory;

public interface InventoryService {
    Inventory updateStock(Inventory inv);
    List<Inventory> all();
}
