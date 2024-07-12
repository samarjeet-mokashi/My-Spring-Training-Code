package com.boa.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boa.entity.Admin;
import com.boa.repository.AdminRepository;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository AdminRepository;

    @Autowired
    public AdminController(AdminRepository AdminRepository) {
        this.AdminRepository = AdminRepository;
    }

    @GetMapping  // request mapping  change 
    public List<Admin> getAllAdmins() {
        return AdminRepository.findAll();
    }

    @PostMapping
    public Admin addAdmin(@RequestBody Admin Admin) {
        return AdminRepository.save(Admin);
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return AdminRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        if (AdminRepository.existsById(id)) {
            updatedAdmin.setId(id);
            return AdminRepository.save(updatedAdmin);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        AdminRepository.deleteById(id);
    }
}

