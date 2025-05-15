package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AdminDTO {

    @NotBlank(message = "ID must be filled")
    private String id;

    @Size(min = 6, message = "Password must be at least 6 characters")
    @NotBlank(message = "Password must be filled")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}