package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserPayDTO;
import com.example.demo.service.SubscriptionServiceView;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class SubscriptionControllerView 
{
	@Autowired 
	
	SubscriptionServiceView service;

	@GetMapping("/payments")
	public ResponseEntity<?> getPayments(HttpSession session)
	{
	   
	    List<UserPayDTO> payments = service.getPaymentsByEmail();
	    if (payments.isEmpty()) 
        {
            return ResponseEntity.noContent().build();
        } 
        else 
        	
        {
            return ResponseEntity.ok(payments);
        }
	}

}
