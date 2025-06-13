package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class NotificationDTO {
	
	@NotBlank(message="email must be enter")
	private String useremail;
	@NotBlank(message="notificaton must be enter")
	private String notification;
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	

}
