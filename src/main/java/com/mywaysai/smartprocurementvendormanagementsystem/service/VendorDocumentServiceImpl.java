package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorDocument;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorDocumentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository repository;

    public VendorDocument upload(VendorDocument doc){
        return repository.save(doc);
    }
    private final VendorDocumentRepository repo;
    private final VendorRepository vendorRepository;

    @Override
    public VendorDocument save(Long vendorId, String type, String number) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        VendorDocument doc = new VendorDocument();
        doc.setDocumentType(type);
        doc.setDocumentNumber(number);
        doc.setVendor(vendor);

        return repo.save(doc);
    }

    @Override
    public List<VendorDocument> getAll() {
        return repo.findAll();
    }
}
