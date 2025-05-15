package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class ViewAllUsersService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers()
    {
        List<User> users = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();

        for (User user : users) 
        {
            UserDTO dto = new UserDTO();
            dto.setEmail(user.getEmail());
            dto.setName(user.getName());
            dto.setPassword(user.getPassword());
            dto.setContact(user.getContact());
            dto.setSecurity(user.getSecurity());
            dto.setAddress(user.getAddress());
            dto.setAnswer(user.getAnswer());
            dto.setAge(user.getAge()); // ✅ Age added
            dto.setToday(user.getToday()); // ✅ Date added
            dtoList.add(dto);
        }

        return dtoList;
    }
    

    // Delete user by ID
    public UserDTO deleteUserById(UserDTO userDTO)
    {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if(user != null)
        {
            userRepository.delete(user); // 🔥 Actual deletion
            UserDTO userdto = new UserDTO();
            userdto.setEmail(userDTO.getEmail());
            return userdto;
        } 
        else 
        {
            return null;
        }
    }
}
