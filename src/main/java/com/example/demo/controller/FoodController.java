package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AdminDisDTO;
import com.example.demo.service.FoodService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/health")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/solutions")
    public ResponseEntity<?> getUserSolutions(HttpSession session) {
        String email = (String) session.getAttribute("useremail");

        if (email == null) {
            return ResponseEntity.status(401).build(); // Unauthorized
        }

       List<AdminDisDTO> solution = foodService.getFirstSolutionByEmail(email);

        if (solution == null) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }

        return ResponseEntity.ok(solution); // 200 OK with data
    }
}