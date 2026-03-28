package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.LoginRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.dto.LoginResponse;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Department;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Role;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.DepartmentRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RoleRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.User;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository  departmentRepository;

    private final VendorRepository vendorRepository;
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User createUser(User user) {

        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setUsername(user.getUsername());
        user1.setActive(true);

        Role role = roleRepository.findById(user.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));


        Department department = departmentRepository.findById(user.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        user1.setDepartment(department);
        user1.setRole(role);

        return repository.save(user1);
    }
    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }



//    @Override
//    public User login(String email) {
//        return repository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }





//    @Override
//    public LoginResponse login(LoginRequest request) {
//
//        User user = repository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new RuntimeException("Invalid email"));
//
//        if (!user.getPassword().equals(request.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        if (user.getRole() == null) {
//            throw new RuntimeException("User role not assigned");
//        }
//
//        String token = "dummy-token";
//
//        return new LoginResponse(
//                token,
//                user.getRole().getRoleName()
//        );
//    }














//    @Override
//    public LoginResponse login(LoginRequest request) {
//
//        User user = repository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new RuntimeException("Invalid email"));
//
//        if (!user.getPassword().equals(request.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
//
//        if (user.getRole() == null) {
//            throw new RuntimeException("User role not assigned");
//        }
//
//        // 🔥 IMPORTANT CHECK FOR VENDOR
//        if (user.getRole().getRoleName().equalsIgnoreCase("VENDOR")) {
//
//            Vendor vendor = vendorRepository.findByEmail(user.getEmail())
//                    .orElseThrow(() -> new RuntimeException("Vendor record not found"));
//
//            if (!vendor.isApproved()) {
//                throw new RuntimeException("Vendor not approved by admin yet");
//            }
//        }
//
//        String token = "dummy-token";
//
//        return new LoginResponse(
//                token,
//                user.getRole().getRoleName()
//        );
//    }



    @Override
    public LoginResponse login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        if (user.getRole() == null) {
            throw new RuntimeException("User role not assigned");
        }

        // 🔥 CHECK ONLY IF ROLE = VENDOR
        if (user.getRole().getRoleName().equalsIgnoreCase("VENDOR")) {

            Optional<Vendor> optionalVendor = vendorRepository.findByEmail(user.getEmail());

            // If vendor record exists → it is outside registered vendor
            if (optionalVendor.isPresent()) {//

                Vendor vendor = optionalVendor.get();

                if (!vendor.isApproved()) {
                    throw new RuntimeException("Vendor not approved by admin yet");
                }
            }

            // If NOT present → it means admin created vendor user
            // So allow login
        }

        return new LoginResponse(
                "dummy-token",
                user.getRole().getRoleName()
        );
    }
}
