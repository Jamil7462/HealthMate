package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.notification;


@Repository
public interface  NotificationRepository extends JpaRepository<notification,Long>
{
	List<notification> findByUseremail(String useremail);  // ✅

}
