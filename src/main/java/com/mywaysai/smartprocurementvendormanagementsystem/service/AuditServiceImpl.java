package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.AuditLog;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.AuditLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {

    private final AuditLogRepository repository;

    public AuditLog log(String action, String user){
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setPerformedBy(user);
        log.setTime(LocalDateTime.now());
        return repository.save(log);
    }
}

