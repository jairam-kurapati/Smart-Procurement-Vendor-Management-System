package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;
import com.mywaysai.smartprocurementvendormanagementsystem.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;

    @PostMapping
    public Role add(@RequestBody Role r){
        return service.create(r);
    }

    @GetMapping
    public List<Role> list(){
        return service.list();
    }
}
