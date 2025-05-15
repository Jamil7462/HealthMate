package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminDTO;
import com.example.demo.service.AdminLoginService;
@RestController
@RequestMapping("/api/login")
public class AdminLoginController {

    @Autowired
    AdminLoginService adminloginservice;

    @PostMapping("/logins")
    public ResponseEntity<?> signin(@RequestBody AdminDTO admindto)
    {
        AdminDTO admin = adminloginservice.signins(admindto);
        if (admin != null) 
        {
            return ResponseEntity.ok("success");  // Send admin data with success response
        } else 
        {
            return ResponseEntity.status(401).body("Invalid email or password");  // Clear message
        }
    }
}

