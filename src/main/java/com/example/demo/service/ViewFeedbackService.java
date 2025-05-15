package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FeedbackDTO;
import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
@Service
public class ViewFeedbackService {
	
	
	@Autowired
	private FeedbackRepository feedabckrepository;
	
	
	public List<FeedbackDTO> getAllFeddback()
	
	{
		
		List<Feedback> Users= feedabckrepository.findAll();
		List<FeedbackDTO> listdto = new ArrayList<>();
		for(Feedback user: Users)
			
		{
			FeedbackDTO feedback = new  FeedbackDTO();
			feedback.setMessage(user.getMessage());
			feedback.setRatting(user.getRatting());
			feedback.setEmail(user.getEmail());
			feedback.setId(user.getId());
			
			listdto.add(feedback);
		}
		return listdto;

	}
	
}
