package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Approval;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ApprovalRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RequisitionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {

    private final ApprovalRepository approvalRepository;
    private final RequisitionRepository requisitionRepository;

    public Approval approve(Long reqId){

        Requisition req = requisitionRepository.findById(reqId).orElseThrow();
        req.setStatus("APPROVED");

        Approval approval = new Approval();
        approval.setRequisition(req);
        approval.setDecision("APPROVED");
        approval.setApprovedDate(LocalDateTime.now());

        requisitionRepository.save(req);
        return approvalRepository.save(approval);
    }
}
