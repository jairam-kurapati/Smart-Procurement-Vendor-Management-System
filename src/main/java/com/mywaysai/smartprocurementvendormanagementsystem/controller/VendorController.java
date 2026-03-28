package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.service.VendorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/vendors")
@RequiredArgsConstructor
public class VendorController {

    private final VendorService service;

    @PostMapping
    public Vendor add(@RequestBody Vendor v){
        return service.register(v);
    }

    @GetMapping
    public List<Vendor> all(){
        return service.getAll();
    }

    @PutMapping("/{id}/approve")
    public Vendor approve(@PathVariable Long id){
        return service.approveVendor(id);
    }
}
