package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email); // Fetch user by email (custom method)

   // User findByEmailAndAnswer(String email, String answer); // Fetch user by email and answer
}
