package com.example.demo.controller;

import com.example.demo.dto.PdfFileDTO;
import com.example.demo.service.PdfFileService;

import jakarta.servlet.http.HttpSession;

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
    public ResponseEntity<PdfFileDTO> uploadPdf(@RequestParam("description") String description, @RequestParam("file") MultipartFile file,HttpSession session)
    {
        try 
        {
        	String email =(String) session.getAttribute("useremail");
        	session.setAttribute("dis",description);
            PdfFileDTO dto = service.savePdf(email,description, file);
            return ResponseEntity.ok(dto);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
