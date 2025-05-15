package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminDTO;
import com.example.demo.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/insert")
@Validated
public class AdminController {
	
	
	@Autowired 
	
	AdminService adminservice;
	@PostMapping("/signup")
	public ResponseEntity<String> admin(@Valid @RequestBody AdminDTO admindto)
	
	{
	      	adminservice.adminsignup(admindto);
	      	
	      	
	      	
	      	return ResponseEntity.noContent().build();
	}

}
