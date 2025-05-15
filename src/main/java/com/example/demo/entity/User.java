package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_signup")
public class User {

    @Id
    @Column(name = "user_email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_pass", nullable = false)
    private String password;

    @Column(name = "user_security", nullable = false)
    private String security;

    @Column(name = "user_answer", nullable = false)
    private String answer;

    @Column(name = "user_contact", nullable = false)
    private String contact;

    @Column(name = "user_address", nullable = false)
    private String address;

    @Column(name = "user_age")
    private String age;  

    @Column(name = "user_date")
    private LocalDate today = LocalDate.now();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public LocalDate getToday() {
		return today;
	}

	public void setToday(LocalDate today) {
		this.today = today;
	}

    // Getters and Setters
    
    

}