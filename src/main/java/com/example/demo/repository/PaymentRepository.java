package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserPayment;

public interface PaymentRepository extends JpaRepository<UserPayment, Long> {
    List<UserPayment> findByEmailAndExpiryDateAfter(String email, LocalDate date);
}
