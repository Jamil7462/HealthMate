package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class ProfileService {

    @Autowired
    UserRepository userRepository;

    public UserDTO profile(String email, String name, String contact, String address) {

        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Update the actual entity
            user.setName(name);
            user.setContact(contact);
            user.setAddress(address);

            userRepository.save(user); // Now it saves updated data

            // Send updated data back as DTO
            UserDTO userdto = new UserDTO();
            userdto.setName(name);
            userdto.setContact(contact);
            userdto.setAddress(address);

            return userdto;
        } else {
            return null;
        }
    }

}
