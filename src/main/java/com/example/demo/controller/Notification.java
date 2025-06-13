package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class Notification {

    @Autowired
    private FeedbackRepository feedabckrepository;

    @GetMapping("/getemail/{id}")
    public ResponseEntity<?> getEmailById(@PathVariable String id, HttpSession session)
    {
    	String email = (String) session.getAttribute("useremail");
    	if(email==null)
    	{
    		return ResponseEntity.ok("user not login");
    	}
        try {
            Long longId = Long.parseLong(id);  // String to Long convert
            Optional<Feedback> feedback = feedabckrepository.findById(longId);
             
            if (feedback.isPresent()) {
                String emails = feedback.get().getEmail();  // 🟢 Assuming getEmail() exists
                return ResponseEntity.ok(emails);
            } else {
                return ResponseEntity.status(404).body("Email not found");
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid ID format");
        }
    }
}
