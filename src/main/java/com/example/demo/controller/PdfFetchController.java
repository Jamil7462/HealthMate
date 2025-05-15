package com.example.demo.controller;

import com.example.demo.dto.PdfFileDTO;
import com.example.demo.service.PdfFetchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pdf")
public class PdfFetchController {

    @Autowired
    private PdfFetchService service;

    // API to fetch all PDF metadata (id & description)
    @GetMapping("/list")
    public ResponseEntity<List<PdfFileDTO>> fetchAll() {
        List<PdfFileDTO> pdfs = service.getAllPdfs();
        return ResponseEntity.ok(pdfs);
    }

    // API to download single PDF by ID
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) {
        return service.downloadPdf(id);
    }
}
