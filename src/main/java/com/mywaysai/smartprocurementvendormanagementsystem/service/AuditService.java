package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.AuditLog;

public interface AuditService {
    AuditLog log(String action, String user);
}
