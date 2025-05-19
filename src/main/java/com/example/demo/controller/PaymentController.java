package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserPayDTO;
import com.example.demo.service.PaymentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payment")
@Validated
public class PaymentController {

    @Autowired
    PaymentService paymentservice;

    @PostMapping("/payment")
    public ResponseEntity<String> payment(@Valid @RequestBody UserPayDTO userpaydto, HttpSession session) {
        String email = (String) session.getAttribute("useremail");

        System.out.println("Email from session: " + email);

        paymentservice.payments(email, userpaydto);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/check_subscription")
    public ResponseEntity<String> checkSubscription(HttpSession ses) {
        String email = (String) ses.getAttribute("useremail");
        if (email == null) {
            return ResponseEntity.status(401).body("User not logged in.");
        }

        boolean hasActiveSubscription = paymentservice.hasActiveSubscription(email);

        if (hasActiveSubscription) {
            return ResponseEntity.ok("You already have an active subscription.");
        } else {
            return ResponseEntity.status(400).body("No active subscription found.");
        }
    }
}
