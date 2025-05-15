

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.ViewAllUsersService;

@RestController
@RequestMapping("/public")
public class ViewAllUsersController
{

    @Autowired
    private ViewAllUsersService publicUserService;

    @GetMapping("/allusers")
    public ResponseEntity<List<UserDTO>> getAllUsers()
    {
        List<UserDTO> allUsers = publicUserService.getAllUsers();
        if (allUsers.isEmpty()) 
        {
            return ResponseEntity.noContent().build();
        } 
        else 
        	
        {
            return ResponseEntity.ok(allUsers);
        }
    }
    
    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteUser(@RequestBody UserDTO userDTO) 
    
    {
        UserDTO deleted = publicUserService.deleteUserById(userDTO);
        if (deleted!=null) 
        {
            return ResponseEntity.ok("User deleted successfully");
        } else 
        {
        	return ResponseEntity.status(401).body("No user logged in");
        }
    }

}
