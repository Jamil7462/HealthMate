package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class AdminDisDTO {
	
	private Long id;
	
	
	@NotBlank(message="disease is not empty")
	private String disease;
	
	@NotBlank(message="food is not empty")
	private String foodtext;
	
	@NotBlank(message="medicine is not empty")
	private String medicinetext;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getFoodtext() {
		return foodtext;
	}

	public void setFoodtext(String foodtext) {
		this.foodtext = foodtext;
	}

	public String getMedicinetext() {
		return medicinetext;
	}

	public void setMedicinetext(String medicinetext) {
		this.medicinetext = medicinetext;
	}
	
	
	
	
	

}
