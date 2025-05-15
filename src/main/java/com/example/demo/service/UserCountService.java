package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;


@Service
public class UserCountService {

    @Autowired
    private UserRepository signupRepo;

    public long getUserCount() {
        return signupRepo.count(); // returns total number of users
    }
}
