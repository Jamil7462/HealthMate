package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SigninDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User; // ✅ Correct import
import com.example.demo.repository.UserRepository;

@Service
public class SigninService {

    @Autowired
    UserRepository userRepository;
    @Autowired 
    BCryptPasswordEncoder encode;;

    public UserDTO Signins(String password, SigninDTO signinDTO) {
        User user = userRepository.findByEmail(signinDTO.getEmail());
        if (user != null)
        {
        	if(encode.matches(password,user.getPassword()))
        	{
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setName(user.getName());
            userDTO.setContact(user.getContact());
            userDTO.setAddress(user.getAddress());
            return userDTO;
        }
       
    }
        return null;
}
}

