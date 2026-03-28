package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Approval;
import com.mywaysai.smartprocurementvendormanagementsystem.service.ApprovalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/approvals")
@RequiredArgsConstructor
public class ApprovalController {

    private final ApprovalService service;

    @PostMapping("/{id}")
    public Approval approve(@PathVariable Long id){
        return service.approve(id);
    }
}

