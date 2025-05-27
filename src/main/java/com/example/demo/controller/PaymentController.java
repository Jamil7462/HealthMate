package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserPayDTO;
import com.example.demo.entity.UserPayment;
import com.example.demo.service.PaymentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payment")
@Validated
public class PaymentController {

    @Autowired
    private PaymentService service;

    /* --------- POST /payment  (save) ---------- */
    @PostMapping("/payment")
    public ResponseEntity<String> addPayment(@Valid @RequestBody UserPayDTO dto,
                                             HttpSession session) {

        String email = (String) session.getAttribute("useremail");
        if (email == null) {                       // safety check
            return ResponseEntity.status(401).body("User not logged in.");
        }
        service.savePayment(email, dto);
        return ResponseEntity.ok("success");
    }

    /* --------- GET /check_subscription -------- */
    @GetMapping("/check_subscription")
    public ResponseEntity<String> checkSubscription(HttpSession session) {
        String email = (String) session.getAttribute("useremail");
        if (email == null) {
            return ResponseEntity.status(401).body("User not logged in.");
        }

        if (service.hasActiveSubscription(email)) {
            return ResponseEntity.ok("You already have an active subscription.");
        } else {
            return ResponseEntity.status(400).body("No active subscription found.");
        }
    }

    /* --------- GET /info  (latest payment) ---- */
    @GetMapping("/info")
    public ResponseEntity<?> subscriptionInfo(HttpSession session) {
        String email = (String) session.getAttribute("useremail");
        if (email == null) {
            return ResponseEntity.status(401).body("User not logged in.");
        }

        Optional<UserPayment> opt = service.getLatestPayment(email);
        return opt.<ResponseEntity<?>>map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.status(404).body("No payment record found."));
    }
}
