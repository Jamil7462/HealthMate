package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity(name="payment")
public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long id;

    @Column(name="useremail", nullable=false)
    private String email;

    @Column(name="paymethod")
    private String paymentmethod;

    @Column(name="payment")
    private String payment;  // spelling fixed here

    @Column(name="date")
    private LocalDate today = LocalDate.now();

    @Column(name="expiry_date")
    private LocalDate expiryDate;

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
