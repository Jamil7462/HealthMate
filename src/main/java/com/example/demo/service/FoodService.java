package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.AdminDis;
import com.example.demo.entity.PdfFile;
import com.example.demo.repository.AdminDisRepository;
import com.example.demo.repository.PdfFileRepository;

@Service
public class FoodService {

    @Autowired
    private AdminDisRepository solutionRepo;

    @Autowired
    private PdfFileRepository diseaseRepo;

    public List<AdminDis> users(String email) {
        // User ke pdf files disease description lene ke liye
        List<PdfFile> diseases = diseaseRepo.findByEmail(email);

        // Description field (disease names) ko extract karo
        List<String> diseaseNames = diseases.stream()
                .map(PdfFile::getDescription)   // PdfFile entity me getDescription method hona chahiye
                .collect(Collectors.toList());

        // AdminDis se matching diseases ke liye solutions lao
        return solutionRepo.findByDiseaseIn(diseaseNames);
    }
}
