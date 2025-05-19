package com.example.demo.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;

public class UserPayDTO {

    private Long id;

    //@NotBlank(message="email not be empty")
    private String email;

    @NotBlank(message="paymentmethod not empty")
    private String paymentmethod;

    @NotBlank(message="payment not be empty")
    private String payment;  // spelling fixed here

    private LocalDate today = LocalDate.now();

    private LocalDate expiryDate;  // नया फ़ील्ड

    // getters-setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPaymentmethod() { return paymentmethod; }
    public void setPaymentmethod(String paymentmethod) { this.paymentmethod = paymentmethod; }

    public String getPayment() { return payment; }
    public void setPayment(String payment) { this.payment = payment; }

    public LocalDate getToday() { return today; }
    public void setToday(LocalDate today) { this.today = today; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
