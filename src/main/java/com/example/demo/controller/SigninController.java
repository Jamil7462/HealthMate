package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SigninDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserDetailsDTO;
import com.example.demo.service.SigninService;

import jakarta.servlet.http.HttpSession;
@RestController
@RequestMapping("/api/signin")
public class SigninController {

	
	@Autowired 
	SigninService signinService;
	@PostMapping("/signin")
	public ResponseEntity<String> Signin(@RequestBody SigninDTO signinDTO, HttpSession session)
	{		
	 UserDTO user =	signinService.Signins(signinDTO.getPassword(),signinDTO);
	if(user!=null)
	{
		 session.setAttribute("username", user.getName());
         session.setAttribute("useremail", user.getEmail());
         session.setAttribute("usercontact", user.getContact());
         session.setAttribute("useraddress", user.getAddress());
         session.setAttribute("useranswer", user.getAnswer());
         
		return ResponseEntity.ok("successs");
	}
	
	else 
    {
        return ResponseEntity.status(401).body("Invalid email");
    }
	}
	@GetMapping("/fetch")
	public ResponseEntity<?> getname(HttpSession session) {
	    String name = (String) session.getAttribute("username");
	    String email = (String) session.getAttribute("useremail");
	    String contact = (String) session.getAttribute("usercontact");
	    String address = (String) session.getAttribute("useraddress");

	    if (name != null && email != null && contact != null && address != null) {
	        UserDetailsDTO userDetails = new UserDetailsDTO(name, email, contact, address);
	        return ResponseEntity.ok(userDetails);
	    } else {
	        return ResponseEntity.status(401).body("No user logged in");
	    }
	}
	
	
}
