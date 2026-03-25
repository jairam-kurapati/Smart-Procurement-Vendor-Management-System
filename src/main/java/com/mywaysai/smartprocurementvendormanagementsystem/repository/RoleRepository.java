package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;


public interface RoleRepository  extends JpaRepository<Role,Long>{
    Role findByRoleName(String vendor);
}
