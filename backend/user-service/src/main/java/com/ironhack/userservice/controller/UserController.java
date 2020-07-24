package com.ironhack.userservice.controller;

import com.ironhack.userservice.model.User;
import com.ironhack.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable(name = "id") Integer id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping("/usere/{email}")
    public User findByEmail(@PathVariable(name="email") String email) {
        return service.findByEmail(email);
    }

    @PostMapping("/user")
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @PutMapping("/user/{id}")
    public User change(@PathVariable(name = "id") Integer id, User user) throws Exception {
        return service.change(id, user);
    }

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable(name = "id") Integer id) throws Exception {
        service.delete(id);
    }

}
