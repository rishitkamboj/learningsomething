package com.rishit.todo.controller;

import com.rishit.todo.entity.User;
import com.rishit.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/public")
public class PublicController {


    @Autowired
    private UserService userService;

@GetMapping("/health-check")
    public String healthCheck(){
        return "OK";
    }


    @PostMapping("/userCreate")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }


}
