package com.mywaysai.smartprocurementvendormanagementsystem.controller;


import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorDocumentRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorDocument;
import com.mywaysai.smartprocurementvendormanagementsystem.service.VendorDocumentService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService service;

    public VendorDocumentController(VendorDocumentService service) {
        this.service = service;
    }

    @PostMapping
    public VendorDocument create(@RequestBody VendorDocumentRequest req){
        return service.save(req.getVendorId(), req.getDocumentType(), req.getDocumentNumber());
    }

    @GetMapping
    public List<VendorDocument> all(){
        return service.getAll();
    }
}



