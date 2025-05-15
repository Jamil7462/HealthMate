package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired BCryptPasswordEncoder passwordencode;
	
	public void Signup(UserDTO userDTO)
	{
		
		User user = new User();
		
		 user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(passwordencode.encode(userDTO.getPassword()));
		user.setSecurity(userDTO.getSecurity());
		user.setAnswer(passwordencode.encode(userDTO.getAnswer()));
		user.setContact(userDTO.getContact());
		user.setAddress(userDTO.getAddress());
		user.setAge(userDTO.getAge());
		user.setToday(userDTO.getToday());
		userRepository.save(user);
		
		
			
	}

}
