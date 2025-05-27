package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AdminDis;
import com.example.demo.service.FoodService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/health")
public class FoodController {

    @Autowired
    private FoodService fodser;

    @GetMapping("/solutions")
    public ResponseEntity<List<AdminDis>> getUserSolutions(HttpSession session) {
        String email = (String) session.getAttribute("useremail");
        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<AdminDis> solutions = fodser.users(email);
        return ResponseEntity.ok(solutions);
    }
}
