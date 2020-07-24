package com.ironhack.commentservice.controller;

import com.ironhack.commentservice.model.Comment;
import com.ironhack.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService service;

    @GetMapping("/comment/{id}")
    public Comment findById(@PathVariable(name = "id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PutMapping("/comment/{id}")
    public Comment change(@PathVariable(name = "id") Integer id, @RequestBody Comment comment) throws Exception {
        return service.change(id, comment);
    }

    @PostMapping("/comment")
    public Comment save(@RequestBody Comment comment){
        return service.save(comment);
    }

    @DeleteMapping("/comment/{id}")
    public void delete(@PathVariable(name = "id") Integer id) throws Exception {
        service.delete(id);
    }

    @GetMapping("/comment-by-pr/{id}")
    public List<Comment> findByProject(@PathVariable(name = "id") Integer id){
        return service.findByProject(id);
    }
}
