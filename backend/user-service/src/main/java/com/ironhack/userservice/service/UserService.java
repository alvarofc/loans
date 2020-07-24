package com.ironhack.userservice.service;

import com.ironhack.userservice.model.User;
import com.ironhack.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public User findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(()-> new Exception("No user with that id."));
    }

    public User findByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Integer id) throws Exception {
        User user = findById(id);
        repository.delete(user);
    }

    public User change(Integer id, User user) throws Exception {
        User old = findById(id);
        user.setId(old.getId());
        return repository.save(user);
    }
}
