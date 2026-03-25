package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor,Long>{
    Optional<Vendor> findByEmail(String email);
}

