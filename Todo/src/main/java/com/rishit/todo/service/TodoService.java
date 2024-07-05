package com.rishit.todo.service;

import com.rishit.todo.entity.Todo;
import com.rishit.todo.entity.User;
import com.rishit.todo.repository.TodoRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class TodoService {

    @Autowired
    private TodoRepo todorepo;
    @Autowired
    private UserService userService;


    @Transactional
   public void saveEntry(Todo todo, String username){
        try{
            User user=userService.findByUsername(username);
        todo.setDate(LocalDate.now());
            Todo save = todorepo.save(todo);
            user.getTodoEntries().add(save);
            userService.saveEntry(user);

        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }


    public void saveEntry(Todo todo){
        try{

            todo.setDate(LocalDate.now());
            Todo save = todorepo.save(todo);
        }
        catch(Exception e){
            log.error(e.getMessage());
        }
    }

    public List<Todo> findAll(){
        return todorepo.findAll();
    }

    public Optional<Todo> findById(ObjectId id){
return todorepo.findById(id);
    }

    public boolean delete(ObjectId id,String username){
        User user=userService.findByUsername(username);
        user.getTodoEntries().removeIf(todo -> todo.getId().equals(id));
        userService.saveEntry(user);
         todorepo.deleteById(id);
         return true;
    }


}
