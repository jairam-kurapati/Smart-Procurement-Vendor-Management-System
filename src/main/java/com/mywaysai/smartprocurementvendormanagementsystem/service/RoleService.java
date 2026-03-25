package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;

public interface RoleService {
    Role create(Role role);
    List<Role> list();
}
