package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Department;
import com.mywaysai.smartprocurementvendormanagementsystem.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    public Department add(@RequestBody Department d){
        return service.add(d);
    }

    @GetMapping
    public List<Department> all(){
        return service.all();
    }
}
