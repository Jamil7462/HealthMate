package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.service.NotificationService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class NotificationController {
	
	@Autowired
	NotificationService notific;
	
	
	@PostMapping("/insert")
	public ResponseEntity<String> notification(@RequestBody NotificationDTO notidto) {
	    String email = notidto.getUseremail();  // 👈 frontend se aaya hua email use karo
	    System.out.println("Sending to email: " + email);
	    notific.insert(email, notidto);
	    return ResponseEntity.ok("success");
	}

	}

