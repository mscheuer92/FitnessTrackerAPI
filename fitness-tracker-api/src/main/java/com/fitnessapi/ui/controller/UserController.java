package com.fitnessapi.ui.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// This controller is responsible for all operations that have to do 
// with users.

@RestController
@RequestMapping("users")  //http://localhost:8088/users/

public class UserController {
    @GetMapping   
    public String getUser()
    {
        return "get user was called";
    }

    @PostMapping
    public String createUser()
    {
        return "create user was called";
    }
  
    @PutMapping   
    public String updateUser()
    {
        return "update user was called";   
    }

    @DeleteMapping
    public String deleteUser()
    {
       return "delete user was called";
    }
}

