package com.rishit.todo.controller;


import com.rishit.todo.entity.Todo;
import com.rishit.todo.entity.User;
import com.rishit.todo.service.TodoService;
import com.rishit.todo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todo")
public class TodoEntryv2Controller {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAllJournalEntriesofUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        List<Todo> all=user.getTodoEntries();
        if(all!=null && !all.isEmpty()) {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("getAlls")
//    public ResponseEntity<List<Todo>> getAlls() {
//        return ResponseEntity.status(HttpStatus.OK).body(todoService.findAll());
//    }

    @PostMapping("/createOne")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            todoService.saveEntry(todo,username);
            return ResponseEntity.status(HttpStatus.CREATED).body(todo);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<?> getTodoById(@PathVariable("myId") ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User byUsername = userService.findByUsername(username);
        if (byUsername == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        List<Todo> todos = byUsername.getTodoEntries();
        if (todos == null || todos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Todo> heh = todos.stream().filter(x -> x.getId().equals(myId)).toList();
        if (!heh.isEmpty()) {
            Optional<Todo> todo = todoService.findById(myId);
            if (todo.isPresent()) {
                return new ResponseEntity<>(todo.get(), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




    @DeleteMapping("deleteIds/{id}")
    public ResponseEntity<?> DeleteTodos(@PathVariable ObjectId id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        todoService.delete(id,username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    @PutMapping("update/{username}/{id}")
    public Todo getTodos(@PathVariable ObjectId id,@RequestBody Todo todo,@PathVariable String username) {
      Todo old=todoService.findById(id).orElse(null);
      if(old!=null) {
         old.setTitle((todo.getTitle()!=null && !todo.getTitle().isEmpty())?todo.getTitle():old.getTitle());
          old.setDescription((todo.getDescription()!=null && !todo.getDescription().isEmpty())?todo.getDescription():old.getDescription());
      }
      todoService.saveEntry(old);
      return old;
    }
}
