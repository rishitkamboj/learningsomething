//package com.example.learning;
//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path="/api")
//public class CheckController {
//
//
//
//    @GetMapping(path="hello")
//    public String body(){
//        return "hello";
//    }
//
//    @GetMapping(path="hello2")
//    public String body2(@RequestParam (name="firstname") String fName ,
//    @RequestParam(name="age" ,required=false)String fAge  ){
//        if(fAge == null){
//            return "YOU DIDNT SEND YOUR AGE ASSHOLE";
//        }
//        return  fName+"'s age is "+fAge;
//    }
//
//    @GetMapping(path="fetch/{name}")
//    public String fetch(@PathVariable(value="name") String n){
//        return n+" did it hehehe";
//    }
//
//    @PostMapping(path="/userdata")
//    public String fetchdata(@RequestBody User user){
//        return "Username is "+user.username+" and email is "+user.email;
//    }
//
//    @GetMapping(path="response")
//    public ResponseEntity<String> response(@RequestParam(name="hey") String n){
//        String output="your name is "+n;
//        return ResponseEntity.status(HttpStatus.OK).body(output);
//    }
//
//}
