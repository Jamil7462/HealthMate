package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admindic")
public class AdminDis {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 
	 private String disease;
	 
	 private String foodtext;
	 
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
