package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.AdminDisDTO;
import com.example.demo.entity.AdminDis;

public interface AdminDisRepository extends JpaRepository<AdminDis, Long> {
	List<AdminDis> findByDiseaseIn(List<String> diseasename);

}
