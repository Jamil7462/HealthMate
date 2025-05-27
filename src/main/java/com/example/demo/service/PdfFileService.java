package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.PdfFileDTO;
import com.example.demo.entity.PdfFile;
import com.example.demo.repository.PdfFileRepository;

@Service
public class PdfFileService {

    @Autowired
    private PdfFileRepository repository;

    public PdfFileDTO savePdf(String email,String description, MultipartFile file) throws Exception {
        PdfFile pdf = new PdfFile();
        pdf.setEmail(email);
        pdf.setDescription(description);
        pdf.setFileData(file.getBytes());
        pdf.setFileName(file.getOriginalFilename());
        pdf.setFileType(file.getContentType());

        PdfFile saved = repository.save(pdf);

        PdfFileDTO dto = new PdfFileDTO();
        dto.setId(saved.getId());
        dto.setDescription(saved.getDescription());
        dto.setFileName(saved.getFileName());
        dto.setFileType(saved.getFileType());
        dto.setEmail(email);

        return dto;
    }
}
