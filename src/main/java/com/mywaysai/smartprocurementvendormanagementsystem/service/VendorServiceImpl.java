package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.User;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RoleRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
//    @Override
//    public Vendor register(Vendor vendor) {
//        vendor.setApproved(false);
//        return repository.save(vendor);
//    }
@Override
public Vendor register(Vendor vendor) {

    vendor.setApproved(false);
    Vendor savedVendor = repository.save(vendor);

    User user = new User();
    user.setEmail(vendor.getEmail());
    user.setPassword(vendor.getPassword());
    user.setUsername(vendor.getCompanyName());
    user.setActive(true);

    Role vendorRole = roleRepository.findByRoleName("VENDOR");
    user.setRole(vendorRole);

    userRepository.save(user);

    return savedVendor;
}
    @Override
    public List<Vendor> getAll() {
        return repository.findAll();
    }

    @Override
    public Vendor approveVendor(Long id) {

        Vendor vendor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        vendor.setApproved(true);

        return repository.save(vendor);
    }
}
