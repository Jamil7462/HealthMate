package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	 Admin findByid(String id); // Corrected parameter name
}
