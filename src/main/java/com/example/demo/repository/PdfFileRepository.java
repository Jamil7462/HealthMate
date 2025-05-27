package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.PdfFile;

public interface PdfFileRepository extends JpaRepository<PdfFile, Long> {
	
	List<PdfFile> findByEmail(String email);
}
