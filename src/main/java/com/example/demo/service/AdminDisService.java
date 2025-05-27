package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDisDTO;
import com.example.demo.entity.AdminDis;
import com.example.demo.repository.AdminDisRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminDisService {
	
	
	@Autowired
	private AdminDisRepository repo;
	
	@Transactional
	public void discription(AdminDisDTO admindto)
	
	{
		AdminDis admindis = new AdminDis();
		
		admindis.setId(admindto.getId());
		
		
		admindis.setDisease(admindto.getDisease());
		
		admindis.setFoodtext(admindto.getFoodtext());
		
		admindis.setMedicinetext(admindto.getMedicinetext());
		
		repo.save(admindis);
		
		
		
		
	}

}
