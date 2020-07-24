package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {
    @GetMapping("/comment/{id}")
    public Comment findById(@PathVariable(name = "id") Integer id) throws Exception;

    @PutMapping("/comment/{id}")
    public Comment change(@PathVariable(name = "id") Integer id, @RequestBody Comment comment) throws Exception;

    @PostMapping("/comment")
    public Comment save(@RequestBody Comment comment);

    @DeleteMapping("/comment/{id}")
    public void delete(@PathVariable(name = "id") Integer id) throws Exception;

    @GetMapping("/comment-by-pr/{id}")
    public List<Comment> findByProject(@PathVariable(name = "id") Integer id);
}
