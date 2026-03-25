package com.mywaysai.smartprocurementvendormanagementsystem.service;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Payment;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    public Payment pay(Payment payment){
        payment.setStatus("PAID");
        return repository.save(payment);
    }
}

