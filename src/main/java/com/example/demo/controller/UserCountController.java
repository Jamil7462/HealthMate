package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserCountService;

@RestController
@RequestMapping("/public")
public class UserCountController {

    @Autowired
    private UserCountService userCountService;

    @GetMapping("/usercount")
    public ResponseEntity<Map<String, Long>> getUserCount() 
    {
        long count = userCountService.getUserCount();
        Map<String, Long> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }
}
