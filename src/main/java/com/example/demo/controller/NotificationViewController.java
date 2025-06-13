package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.service.NotificationViewService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class NotificationViewController {
	
	@Autowired
	NotificationViewService notiserv;
	
	@GetMapping("/views")
	public ResponseEntity<?>  viewnoti(HttpSession session)
	{
		String email = (String) session.getAttribute("useremail");
		List<NotificationDTO> noti = notiserv.notifviews(email);
		if(noti!=null)
		{
			return ResponseEntity.ok(noti);
		}
		else {
			return ResponseEntity.status(401).body("not found");
		}
		
	}

}
