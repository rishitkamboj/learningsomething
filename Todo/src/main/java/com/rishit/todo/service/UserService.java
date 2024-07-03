package com.rishit.todo.service;

import com.rishit.todo.entity.Todo;
import com.rishit.todo.entity.User;
import com.rishit.todo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userrepo;


    public void saveEntry(User user){
        try{

            userrepo.save(user);}
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    public List<User> findAll(){
        return userrepo.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userrepo.findById(id);
    }

    public boolean delete(ObjectId id){
        userrepo.deleteById(id);
        return true;
    }

    public User findByUsername(String userName){
 return userrepo.findByUserName(userName);
    }

}
