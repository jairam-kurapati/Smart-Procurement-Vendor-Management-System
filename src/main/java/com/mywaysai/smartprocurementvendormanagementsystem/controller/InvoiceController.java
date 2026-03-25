package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import com.mywaysai.smartprocurementvendormanagementsystem.service.InvoiceServiceImpl;
import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;


import java.util.List;

@RestController
@RequestMapping("/invoice")
//@RequiredArgsConstructor
public class InvoiceController {



        private final InvoiceServiceImpl service;

        public InvoiceController(InvoiceServiceImpl service) {
            this.service = service;
        }

        @PostMapping
        public Invoice create(@RequestBody Invoice request) {
            return service.create(request);
        }

        @GetMapping
        public List<Invoice> getAll() {
            return service.getAll();
        }

        @GetMapping("/{id}")
        public Invoice getById(@PathVariable Long id) {
            return service.getById(id);
        }


//
//    @PostMapping
//    public Invoice create(@RequestBody Invoice invoice){
//        return service.create(invoice);
//    }


}
