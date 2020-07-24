package com.ironhack.commentservice.service;

import com.ironhack.commentservice.model.Comment;
import com.ironhack.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletionException;

@Service
public class CommentService {
    @Autowired
    CommentRepository repository;

    public Comment findById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(()->new Exception("No comment with that id."));
    }

    public List<Comment> findAll(){
        return repository.findAll();
    }

    public Comment save(Comment comment){
        return repository.save(comment);
    }

    public Comment change(Integer id, Comment comment) throws Exception {
        Comment old = findById(id);
        comment.setId(old.getId());
        return  repository.save(comment);
    }

    public void delete(Integer id) throws Exception {
        Comment comment = findById(id);
        repository.delete(comment);
    }

    public List<Comment> findByProject(Integer id) {
        return repository.findByProject(id);
    }
}
