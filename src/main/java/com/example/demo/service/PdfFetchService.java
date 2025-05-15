package com.example.demo.service;

import com.example.demo.dto.PdfFileDTO;
import com.example.demo.entity.PdfFile;
import com.example.demo.repository.PdfFileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Service
public class PdfFetchService {

    @Autowired
    private PdfFileRepository repository;

    // Fetch all PDF metadata
    public List<PdfFileDTO> getAllPdfs() 
    {
        List<PdfFile> files = repository.findAll();
        return files.stream().map(file ->
        {
            PdfFileDTO dto = new PdfFileDTO();
            dto.setId(file.getId());
            dto.setDescription(file.getDescription());
            return dto;
        }).collect(Collectors.toList());
    }

    // Get single PDF file as ResponseEntity for download
    public ResponseEntity<byte[]> downloadPdf(Long id)
    {
        PdfFile file = repository.findById(id).orElse(null);
        if (file == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=document.pdf")
            .contentType(MediaType.APPLICATION_PDF)
            .body(file.getFileData());
    }
}
