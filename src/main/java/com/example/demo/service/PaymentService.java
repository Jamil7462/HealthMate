package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserPayDTO;
import com.example.demo.entity.UserPayment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentrepo;

    public void payments(String email, UserPayDTO userpaydto) {
        UserPayment payment = new UserPayment();
        payment.setEmail(email);
        payment.setId(userpaydto.getId());
        payment.setPayment(userpaydto.getPayment());
        payment.setPaymentmethod(userpaydto.getPaymentmethod());

        // expiryDate: DTO से अगर आया हो तो use करो, नहीं तो 1 महीने बाद सेट कर दो
        if (userpaydto.getExpiryDate() != null) {
            payment.setExpiryDate(userpaydto.getExpiryDate());
        } else {
            payment.setExpiryDate(LocalDate.now().plusMonths(1));  // default expiry 1 month from now
        }

        paymentrepo.save(payment);

        System.out.println("Payment saved with expiryDate: " + payment.getExpiryDate());
    }

    public boolean hasActiveSubscription(String email) {
        LocalDate today = LocalDate.now();
        return !paymentrepo.findByEmailAndExpiryDateAfter(email, today).isEmpty();
    }
}
