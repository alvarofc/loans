package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.Comment;
import com.ironhack.edgeservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments/{id}")
    public List<Comment> findByProject(@PathVariable(name = "id")Integer id) {
        return commentService.findByProject(id);
    }
}
