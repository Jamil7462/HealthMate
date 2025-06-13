package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.AdminDisDTO;
import com.example.demo.entity.AdminDis;
import com.example.demo.entity.PdfFile;
import com.example.demo.repository.AdminDisRepository;
import com.example.demo.repository.PdfFileRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private AdminDisRepository adminDisRepo;

    @Autowired
    private PdfFileRepository pdfFileRepo;

    public List<AdminDisDTO> getFirstSolutionByEmail(String email) {
        List<PdfFile> pdfFiles = pdfFileRepo.findByEmail(email);

        // disease ke duplicates remove karne ke liye distinct use karte hain
        List<String> diseaseNames = pdfFiles.stream()
                                           .map(PdfFile::getDescription)
                                           .distinct()  // unique disease names only
                                           .collect(Collectors.toList());

        List<AdminDis> matchedDiseases = adminDisRepo.findByDiseaseIn(diseaseNames);

        List<AdminDisDTO> dtoList = new ArrayList<>();
        for (AdminDis ad : matchedDiseases) {
            AdminDisDTO dto = new AdminDisDTO();
            dto.setDisease(ad.getDisease());
            dto.setFoodtext(ad.getFoodtext());
            dto.setMedicinetext(ad.getMedicinetext());
            dtoList.add(dto);
        }

        return dtoList;
    }

    }
