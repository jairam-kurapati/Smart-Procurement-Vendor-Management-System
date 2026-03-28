package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.AuditLog;


public interface AuditLogRepository extends JpaRepository<AuditLog,Long>{ 
}
