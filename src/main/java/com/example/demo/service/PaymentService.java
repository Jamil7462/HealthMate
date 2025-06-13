package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserPayDTO;
import com.example.demo.entity.UserPayment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    /* ---- create payment ---- */
    public void savePayment(String email, UserPayDTO dto) {

        UserPayment p = new UserPayment();
        p.setEmail(email);
        p.setPayment(dto.getPayment());
        p.setPaymentmethod(dto.getPaymentmethod());
        p.setToday(LocalDate.now());

        // expiry – DTO में आये तो use करें, वरना 1 महीना default
        p.setExpiryDate(dto.getExpiryDate() != null ? dto.getExpiryDate(): LocalDate.now().plusMonths(1));

        paymentRepo.save(p);
    }

    /* ---- active? ---- */
    public boolean hasActiveSubscription(String email) {
        return !paymentRepo.findByEmailAndExpiryDateAfter(email, LocalDate.now()).isEmpty();
    }

    /* ---- latest details for UI ---- */
    public Optional<UserPayDTO> getLatestPayment(String email) {
        return paymentRepo.findTopByEmailOrderByExpiryDateDesc(email)
            .map(u -> {
                UserPayDTO ob = new UserPayDTO();
                ob.setEmail(u.getEmail());
                ob.setPayment(u.getPayment());
                ob.setPaymentmethod(u.getPaymentmethod());
                ob.setExpiryDate(u.getExpiryDate());
                ob.setToday(u.getToday());
                return ob;
            });
    }

    }

