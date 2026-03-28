package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Inventory;
import com.mywaysai.smartprocurementvendormanagementsystem.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @PostMapping
    public Inventory update(@RequestBody Inventory inv){
        return service.updateStock(inv);
    }

    @GetMapping
    public List<Inventory> all(){
        return service.all();
    }
}
