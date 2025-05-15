package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class ForgotPasswordService {
	
	
	@Autowired
	UserRepository userrepository;
	
	public UserDTO forgotpass(String email)
	{
	User user = userrepository.findByEmail(email);
	if(user!=null)
	{
		
		UserDTO userdto = new UserDTO();
		userdto.setEmail(user.getEmail());
		userdto.setSecurity(user.getSecurity());
		
		return userdto;
		
	}
	else
	{
	return null;

	}
}
	public UserDTO answer(String email, String answer)
	{
	    User user = userrepository.findByEmail(email);
	    if (user != null)
	    {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        
	        if (encoder.matches(answer, user.getAnswer()))
	        {
	            UserDTO userdto = new UserDTO();
	            userdto.setEmail(user.getEmail());
	            return userdto;
	        }
	    }
	    return null;
	}
	
	public UserDTO password(String email, String password)
	{
	User user =	userrepository.findByEmail(email);
	if(user!=null)
	{
		// save new  password  in database 
		user.setPassword(password);
		userrepository.save(user);
		
		// return data 
		UserDTO userdto = new UserDTO();
		userdto.setEmail(user.getEmail());
		 return userdto;
	}
		return null;
	}
}
