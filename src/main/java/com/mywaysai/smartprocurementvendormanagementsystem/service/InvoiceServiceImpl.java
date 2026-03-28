package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.PurchaseOrder;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Invoice;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.InvoiceRepository;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

   // private final InvoiceRepository repository;

//    public Invoice create(Invoice invoice) {
//        return
//        repository.save(invoice);
//
//    }
    private final InvoiceRepository invoiceRepository;
    private final PurchaseOrderRepository poRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              PurchaseOrderRepository poRepository) {
        this.invoiceRepository = invoiceRepository;
        this.poRepository = poRepository;
    }

    public Invoice create(Invoice request) {

        if (request.getPurchaseOrder() == null ||
                request.getPurchaseOrder().getId() == null) {
            throw new RuntimeException("Purchase Order ID required");
        }

        PurchaseOrder po = poRepository
                .findById(request.getPurchaseOrder().getId())
                .orElseThrow(() -> new RuntimeException("PO not found"));

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(request.getInvoiceNumber());
        invoice.setAmount(request.getAmount());
        invoice.setPurchaseOrder(po);

        return invoiceRepository.save(invoice);
    }


    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public Invoice getById(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

//    @Override
//    public Invoice create(Invoice invoice) {
//        return null;
//    }
}

