package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Department;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;

    public Department add(Department d){
        return repository.save(d);
    }

    public List<Department> all(){
        return repository.findAll();
    }
}
