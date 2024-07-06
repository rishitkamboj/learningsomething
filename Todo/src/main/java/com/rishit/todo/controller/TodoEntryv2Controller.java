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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/todo")
public class TodoEntryv2Controller {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;


    @GetMapping("/getAll/{username}")
    public ResponseEntity<?> getAllJournalEntriesofUser(@PathVariable String username) {
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

    @PostMapping("/createOne/{username}")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo, @PathVariable String username) {
        try{

            todoService.saveEntry(todo,username);
            return ResponseEntity.status(HttpStatus.CREATED).body(todo);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }




    @GetMapping("getIds")
    public ResponseEntity<Todo> getTodo(@RequestParam(value = "id")ObjectId id ) {
        Optional<Todo> todo=todoService.findById(id);
        if(todo.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(todo.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("getIds/{id}")
    public ResponseEntity<Todo> getTodos(@PathVariable ObjectId id) {
       Optional<Todo> todo=todoService.findById(id);
       if(todo.isPresent()) {
           return ResponseEntity.status(HttpStatus.OK).body(todo.get());
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @DeleteMapping("deleteIds/{username}/{id}")
    public ResponseEntity<?> DeleteTodos(@PathVariable ObjectId id,@PathVariable String username) {
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
