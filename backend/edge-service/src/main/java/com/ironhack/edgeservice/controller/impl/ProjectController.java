package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.model.Project;
import com.ironhack.edgeservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService service;

    @GetMapping("/projects")
    public List<Project> findAll(){
        return service.findAll();
    }
    @GetMapping("project/{id}")
    public Project findByid(@PathVariable(name = "id") Integer id) throws Exception {
        return service.findById(id);
    }
}
