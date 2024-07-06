package com.rishit.todo.service;

import com.rishit.todo.entity.User;
import com.rishit.todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByUserName(username);
        if(user!=null){
            UserDetails build = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUserName())
                    .password(user.getPassWord())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();
            return build;
        }
        throw new UsernameNotFoundException("UserName not found with username "+username);
    }

}


