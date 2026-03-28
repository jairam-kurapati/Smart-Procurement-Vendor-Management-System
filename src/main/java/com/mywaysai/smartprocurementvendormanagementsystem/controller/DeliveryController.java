package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.DeliveryRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Delivery;
import com.mywaysai.smartprocurementvendormanagementsystem.service.DeliveryService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @PostMapping
    public Delivery create(@RequestBody DeliveryRequest request) {
        return service.createDelivery(
                request.getPurchaseOrderId(),
                request.getTrackingNumber(),
                request.getDeliveryStatus()
        );
    }

    @GetMapping
    public List<Delivery> getAll(){
        return service.getAll();
    }
}

