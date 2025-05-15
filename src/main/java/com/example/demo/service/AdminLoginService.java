package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminLoginService {

    @Autowired
    AdminRepository adminrepository;

    public AdminDTO signins(AdminDTO admindto) {
    	Admin admin = adminrepository.findById(admindto.getId()).orElse(null);
        if (admin != null) {
            AdminDTO admindtos = new AdminDTO();
            admindtos.setId(admin.getId());
            return admindtos;
        }
        return null;
    }
}
