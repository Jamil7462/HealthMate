package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/insert")
@Validated
public class UserController {
	
	
	@Autowired
	UserService userService;
	@PostMapping("/insert")
	public ResponseEntity<String> SignupUser(@Valid @RequestBody UserDTO userDTO)
	{
		userService.Signup(userDTO);
		
		return ResponseEntity.noContent().build();
	}

}
