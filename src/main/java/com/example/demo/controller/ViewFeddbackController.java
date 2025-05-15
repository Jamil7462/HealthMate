package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FeedbackDTO;
import com.example.demo.service.ViewFeedbackService;
@RestController
@RequestMapping("/api/feedback")
public class ViewFeddbackController
{
	
	
	@Autowired 
	private ViewFeedbackService feedbackservice;
	
	@GetMapping("/feedback")
	public ResponseEntity<List<FeedbackDTO>> getAllFeedback()
	{
		List<FeedbackDTO> alluser = feedbackservice.getAllFeddback();
		
		if(alluser.isEmpty())
		{
			return ResponseEntity.noContent().build();
		}
		
		else
		{
			return ResponseEntity.ok(alluser);
		}

}
}
