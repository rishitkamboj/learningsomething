package com.rishit.todo.controller;


import com.rishit.todo.entity.User;
import com.rishit.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.findAll();
    }


    @PutMapping("/update")
    public ResponseEntity<?> changeUser(@RequestBody User user){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username=authentication.getName();
        User byUsername = userService.findByUsername(username);

            byUsername.setUserName(user.getUserName());
             byUsername.setPassWord(user.getPassWord());
            userService.saveNewUser(byUsername);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        User byUsername = userService.findByUsername(username);
        userService.delete(byUsername.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
