package com.example.demo.controller;

import com.example.demo.dto.PdfFileDTO;
import com.example.demo.service.PdfFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/pdf")
public class PdfFileController {

    @Autowired
    private PdfFileService service;

    @PostMapping("/upload")
    public ResponseEntity<PdfFileDTO> uploadPdf(@RequestParam("description") String description, @RequestParam("file") MultipartFile file)
    {
        try 
        {
            PdfFileDTO dto = service.savePdf(description, file);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
