package com.ironhack.projectservice.controller;

import com.ironhack.projectservice.model.Project;
import com.ironhack.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectService service;

    @GetMapping("/projects")
    public List<Project> findAll() {
        return service.findAll();
    }

    @GetMapping("/project/{id}")
    public Project findById(@PathVariable(name = "id") Integer id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/projects/{owner}")
    public List<Project> findByOwner(@PathVariable(name = "owner") Integer owner){
        return service.findByOwner(owner);
    }

    @PutMapping("/project/{id}")
    public Project change(@PathVariable(name = "id") Integer id, @RequestBody Project project) throws Exception {
        return service.change(id, project);
    }
    @DeleteMapping("/project/{id}")
    public void delete(@PathVariable(name = "id") Integer id) throws Exception {
        service.delete(id);
    }

    @PostMapping("/project")
    public Project save(@RequestBody Project project) {
        return service.save(project);
    }

}
