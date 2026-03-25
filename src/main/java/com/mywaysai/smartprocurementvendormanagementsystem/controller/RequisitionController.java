package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.service.RequisitionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/requisitions")
@RequiredArgsConstructor
public class RequisitionController {

    private final RequisitionService service;

    @PostMapping
    public Requisition create(@RequestBody Requisition r){
        return service.create(r);
    }

    @GetMapping
    public List<Requisition> getAll() {
        return service.findAll();
    }
}
