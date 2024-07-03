package com.rishit.todo.controller;


import com.rishit.todo.entity.User;
import com.rishit.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/userCreate")
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> changeUser(@RequestBody User user,@PathVariable String username){
        User byUsername = userService.findByUsername(username);
        if(byUsername != null){
            byUsername.setUserName(user.getUserName());
             byUsername.setPassWord(user.getPassWord());
            userService.saveEntry(byUsername);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
