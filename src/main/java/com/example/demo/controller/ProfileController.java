package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.ProfileService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/apiuser")
public class ProfileController{
	
	
	@Autowired
	ProfileService profileService;
	
	@PutMapping("/profile")
	public ResponseEntity<String> prifileupdate(   @RequestBody UserDTO userDTO,HttpSession session)
	{
	    String email = (String) session.getAttribute("useremail");

	    UserDTO user = profileService.profile(email, userDTO.getName(), userDTO.getContact(), userDTO.getAddress());

	    if (user != null) {
	        return ResponseEntity.ok("success");
	    } else {
	        return ResponseEntity.status(404).body("user not logged");
	    }
	}

	
	

}
