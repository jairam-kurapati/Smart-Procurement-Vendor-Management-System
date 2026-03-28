package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public Role create(Role role){
        return repository.save(role);
    }

    public List<Role> list(){
        return repository.findAll();
    }
}
