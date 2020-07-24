package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.CommentServiceClient;
import com.ironhack.edgeservice.model.Comment;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentServiceClient client;

    public List<Comment> findByProject(Integer id) {
        return client.findByProject(id);
    }
}
