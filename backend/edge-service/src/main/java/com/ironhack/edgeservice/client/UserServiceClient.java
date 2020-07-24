package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserServiceClient {
    @GetMapping("/user/{id}")
    public User findById(@PathVariable(name = "id") Integer id) throws Exception;

    @GetMapping("/users")
    public List<User> findAll();

    @GetMapping("/usere/{email}")
    public User findByEmail(@PathVariable(name="email") String email);

    @PostMapping("/user")
    public User save(@RequestBody User user);

    @PutMapping("/user/{id}")
    public User change(@PathVariable(name = "id") Integer id, User user) throws Exception;

    @DeleteMapping("user/{id}")
    public void delete(@PathVariable(name = "id") Integer id) throws Exception;
}
