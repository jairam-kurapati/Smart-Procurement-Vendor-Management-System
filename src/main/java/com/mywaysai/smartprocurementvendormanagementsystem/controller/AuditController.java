//package com.mywaysai.smartprocurementvendormanagementsystem.controller;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.mywaysai.smartprocurementvendormanagementsystem.entity.AuditLog;
//import com.mywaysai.smartprocurementvendormanagementsystem.service.AuditService;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/audit")
//@RequiredArgsConstructor
//public class AuditController {
//
//    private final AuditService service;
//
//    @PostMapping
//    public AuditLog log(@RequestParam String action,@RequestParam String user){
//        return service.log(action,user);
//    }
//}
