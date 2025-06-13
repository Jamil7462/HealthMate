package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserPayDTO;
import com.example.demo.entity.UserPayment;
import com.example.demo.repository.PaymentRepository;

@Service
public class SubscriptionServiceView {

    @Autowired
    PaymentRepository paymentrepo;

    public List<UserPayDTO> getPaymentsByEmail() {
        List<UserPayment> payments = paymentrepo.findAll();
        List<UserPayDTO> dtoList = new ArrayList<>();

        for (UserPayment payment : payments) {
            UserPayDTO dto = new UserPayDTO();
            dto.setId(payment.getId());
            dto.setEmail(payment.getEmail());
            dto.setPayment(payment.getPayment());
            dto.setPaymentmethod(payment.getPaymentmethod());
            dto.setToday(payment.getToday());
            dto.setExpiryDate(payment.getExpiryDate());
            dtoList.add(dto);
        }

        return dtoList;
    }
}
