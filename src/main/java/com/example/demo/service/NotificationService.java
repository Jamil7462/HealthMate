package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.entity.notification;
import com.example.demo.repository.NotificationRepository;

@Service
public class NotificationService {
	
	
	@Autowired
	NotificationRepository notif;
	
	
	public void insert(String email, NotificationDTO noti)
	{
		
		notification notiob = new notification();
		notiob.setUseremail(email);
		notiob.setNotification(noti.getNotification());
		notif.save(notiob);

		
		notif.save(notiob);
	}

}
