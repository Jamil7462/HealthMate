package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDTO;
import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service

public class AdminService {
	
	
	@Autowired
	AdminRepository adminrepository;
	
	
	public void adminsignup(AdminDTO admindto)
	{
		Admin admin = new Admin();
		
		admin.setId(admindto.getId());  // Correctly set the ID from the DTO

		admin.setPassword(admindto.getPassword());
		
		
		adminrepository.save(admin);
	}

}
