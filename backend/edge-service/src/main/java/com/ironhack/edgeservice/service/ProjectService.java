package com.ironhack.edgeservice.service;

import com.ironhack.edgeservice.client.ProjectServiceClient;
import com.ironhack.edgeservice.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectService {
    @Autowired
    ProjectServiceClient client;

    public List<Project> findAll(){
        return client.findAll();
    }

    public Project findById(Integer id) throws Exception {
        return client.findById(id);
    }
}
