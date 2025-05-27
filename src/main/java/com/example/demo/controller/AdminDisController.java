package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminDisDTO;
import com.example.demo.service.AdminDisService;

@RestController
@RequestMapping("api/dis")
public class AdminDisController {

    @Autowired
    private AdminDisService adser;

    // Insert admin data
    @PostMapping("/description")
    public ResponseEntity<String> admindis(@RequestBody AdminDisDTO adminDTO) {
    	adser.discription(adminDTO);
        return ResponseEntity.ok("Admin data saved successfully");
    }

   

}
