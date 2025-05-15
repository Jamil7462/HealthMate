package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FeedbackDTO;
import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
@Service
public class FeedbackService {
	
	
	
	@Autowired 
	FeedbackRepository feedbackrepo;
	
	
	public void feedback( String email,FeedbackDTO feedbackdto)
	{
		Feedback feedback = new Feedback();
		
		//feedback.setEmail(feedbackdto.getEmail());
		feedback.setEmail(email);
		
		//feedback.setId(feedbackdto.getId());
		
		feedback.setMessage(feedbackdto.getMessage());
		
		feedback.setRatting(feedbackdto.getRatting());
		
		feedbackrepo.save(feedback);
		
		
	}
}
