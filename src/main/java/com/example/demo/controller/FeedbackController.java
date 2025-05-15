package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FeedbackDTO;
import com.example.demo.service.FeedbackService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackservice;
	  
	
	@PostMapping("/feedbackinsert")
	public ResponseEntity<String> feedback(@RequestBody FeedbackDTO feedbackdto, HttpSession session)
	{
		
		 String email = (String) session.getAttribute("useremail");
		feedbackservice.feedback(email,feedbackdto);
	     
	     return ResponseEntity.noContent().build();
		
	     }
	
	
}
