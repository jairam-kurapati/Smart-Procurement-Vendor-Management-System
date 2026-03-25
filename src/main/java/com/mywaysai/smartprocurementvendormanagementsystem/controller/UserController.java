package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.LoginRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.dto.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.User;
import com.mywaysai.smartprocurementvendormanagementsystem.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
//@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5180")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public User save(@RequestBody User u){
        return service.createUser(u);
    }

    @GetMapping
    public List<User> all(){
        return service.getAll();
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }
}
