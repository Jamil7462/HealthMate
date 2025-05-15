package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.ForgotPasswordService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/forgot")
public class ForgotPasswordController {
	
	
	
	@Autowired
	ForgotPasswordService forgotservice;
	
	@GetMapping("/forgotpass")
	public ResponseEntity<String> forgot(@RequestParam String email, HttpSession session)
	{
	
	
	UserDTO user = forgotservice.forgotpass(email);
	
	if(user!=null)
	{
		session.setAttribute("email", user.getEmail());
		session.setAttribute("security", user.getSecurity());
		
		return ResponseEntity.ok("successs");
		
	}
	else 
	{
		return ResponseEntity.status(401).body("email invalid");
	}
	
}	

	        
@GetMapping("/fetchsecurity")
public ResponseEntity<String> security(HttpSession session)
{
	//String email = (String) session.getAttribute("email");
	String security = (String) session.getAttribute("security");
	
	
	if(security!=null)
	{
		return ResponseEntity.ok(security);
	}
	else
	{
		return ResponseEntity.status(401).body("email invalid");
	}
}

@GetMapping("/answer")
public ResponseEntity<String> answer(@RequestParam String answer, HttpSession session)
{
	String email = (String) session.getAttribute("email"); // ✅ same key as forgotpass

	
	UserDTO user =forgotservice.answer(email,answer);
	
	if(user!=null)
	{
		return ResponseEntity.ok("success");
	}
	else
	{
		return ResponseEntity.status(401).body("email invalid");
	}
	
	
}

@PutMapping("/updatepassword")

	public ResponseEntity<String> password(@RequestParam String password, HttpSession session)
	{
	String email = (String) session.getAttribute("email"); 

	UserDTO user =forgotservice.password(email,password);

	if(user!=null)
	
	{
	return ResponseEntity.ok("success");
}
else
{
	return ResponseEntity.status(401).body("falid ");
}


}
}
