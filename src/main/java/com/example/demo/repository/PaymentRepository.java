package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserPayment;

/**
 * Repository for <code>UserPayment</code> records.
 */
@Repository
public interface PaymentRepository extends JpaRepository<UserPayment, Long> {

    /* ---------- ACTIVE‑SUBSCRIPTION CHECK ---------- */
    /**
     * Return all payments whose expiryDate is after (>=) the supplied date.
     * Used to decide whether the user still has an active plan.
     */
    List<UserPayment> findByEmailAndExpiryDateAfter(String email, LocalDate date);
    
    List<UserPayment> findByEmail(String emal);

    /* ---------- MOST‑RECENT PAYMENT (optional helper) ---------- */
    /**
     * Handy when you only need the latest payment row
     * (Spring Data parses the keyword chain automatically).
     */
    Optional<UserPayment> findTopByEmailOrderByExpiryDateDesc(String email);
}
