package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.entity.notification;
import com.example.demo.repository.NotificationRepository;

@Service
public class NotificationViewService {

    @Autowired 
    private NotificationRepository notirepo;

    public List<NotificationDTO> notifviews(String  email) {
       // List<notification> notifications = notirepo.findByUseremaill(notidto.getUseremail());
    	List<notification> notifications = notirepo.findByUseremail(email);

        List<NotificationDTO> dtoList = new ArrayList<>();

        if (notifications != null && !notifications.isEmpty()) 
        {
            for (notification noti : notifications)
            {
                NotificationDTO dto = new NotificationDTO();
                dto.setNotification(noti.getNotification()); // Assume getNotification() returns String
               dto.setUseremail(noti.getUseremail()); // optional, if you want to return email also
                dtoList.add(dto);
            }
        }

        return dtoList;
    }
}
