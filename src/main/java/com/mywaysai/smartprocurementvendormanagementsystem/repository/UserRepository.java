package com.mywaysai.smartprocurementvendormanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);

     User findByUsername(String username);
}

